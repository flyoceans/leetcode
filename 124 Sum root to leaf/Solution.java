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
    // private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null)
           return 0;
        // sum = 0;
        return helper(root, 0);
    }
    
    private int helper(TreeNode t, int sum) {
        if (t == null)
            return 0;
        sum = sum*10 + t.val;
        if (t.left == null && t.right == null)
            return sum;
        return helper(t.left, sum) + helper(t.right, sum);
    }
}