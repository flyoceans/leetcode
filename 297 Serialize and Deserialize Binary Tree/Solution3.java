/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // DFS pre-order 
    // Recursive
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#,";
        else {
            String res = String.valueOf(root.val) + ",";
            res += serialize(root.left);
            res += serialize(root.right);
            return res;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        Deque<String> data_list = new ArrayDeque<String>(Arrays.asList(array));
        return rdeserialize(data_list);
    }
    
    public TreeNode rdeserialize(Deque<String> l) {
        // Recursive deserialization.
        String cur = l.pop();
        if (cur.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));