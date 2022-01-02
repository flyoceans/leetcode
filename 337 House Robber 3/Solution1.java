/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Top down
    // Recursive with memo
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        if (map.containsKey(root)) return map.get(root);
        // Compare rob root vs. not rob root
        // rob root; skip direct children
        // not rob root; recursive
        int res = 0;
        int val = root.val;
        int ll = (root.left == null) ? 0 : rob(root.left.left);
        int lr = (root.left == null) ? 0 : rob(root.left.right);
        int rl = (root.right == null) ? 0 : rob(root.right.left);
        int rr = (root.right == null) ? 0 : rob(root.right.right);
        
        res = Math.max(val + ll + lr + rl + rr, rob(root.left) + rob(root.right));
        map.put(root, res);
        return res;
    }
    
    Map<TreeNode, Integer> map = new HashMap<>();
}