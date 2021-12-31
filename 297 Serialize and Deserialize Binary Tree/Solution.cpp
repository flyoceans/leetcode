/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
    // 流 读写
    // 采用status标记 Node状态
    // 当 val 数值很大的时候可以省空间
    // 比如 88888888， 存成string 需要8 bytes可能
    // 存成 int 却只需要 4 bytes
    // 高级解法
public:
 
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        ostringstream out;
        serialize(root, out);
        return out.str();
    }
 
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        istringstream in(data);
        return deserialize(in);
    }
private:
    enum STATUS {
        ROOT_NULL = 0x0,
        ROOT = 0x1,
        LEFT = 0x2,
        RIGHT = 0x4
    };
    
    void serialize(TreeNode* root, ostringstream& out) {
        char status = 0;
        if (root) status |= ROOT;
        if (root && root->left) status |= LEFT;
        if (root && root->right) status |= RIGHT;
        out.write(&status, sizeof(char));        
        if (!root) return;
        out.write(reinterpret_cast<char*>(&(root->val)), sizeof(root->val));
        if (root->left) serialize(root->left, out);
        if (root->right) serialize(root->right, out);
    }
    
    TreeNode* deserialize(istringstream& in) {
        char status;
        in.read(&status, sizeof(char));
        if (!status & ROOT) return nullptr;
        auto root = new TreeNode(0);
        in.read(reinterpret_cast<char*>(&root->val), sizeof(root->val));        
        root->left = (status & LEFT) ? deserialize(in) : nullptr;
        root->right = (status & RIGHT) ? deserialize(in) : nullptr;
        return root;
    }
};
 
// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
