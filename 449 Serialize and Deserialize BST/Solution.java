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
    // DFS
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        rserialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public void rserialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        String[] array = data.split(",");
        Deque<String> q = new ArrayDeque<>(Arrays.asList(array));
        return rdeserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode rdeserialize(Deque<String> q, int l, int r) {
        if (q.isEmpty()) return null;
        
        int cur = Integer.valueOf(q.peek());
        if (cur < l || cur > r) return null;
        
        q.poll();
        TreeNode root = new TreeNode(cur);
        root.left = rdeserialize(q, l, cur-1);
        root.right = rdeserialize(q, cur+1, r);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;