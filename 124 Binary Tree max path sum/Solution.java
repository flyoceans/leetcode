/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        max = Integer.MIN_VALUE;
        rootPathSum(root);
        return max;
    }
    
    private int rootPathSum(TreeNode t) {
        if (t == null)
            return 0;
        int l = Math.max(rootPathSum(t.left), 0);
        int r = Math.max(rootPathSum(t.right), 0);
        max = Math.max(max, l + r + t.val);
        return Math.max(l, r) + t.val;
    }
}