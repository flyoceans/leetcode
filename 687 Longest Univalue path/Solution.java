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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        ans = 0;
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftPath = helper(left);
        int rightPath = helper(right);
        int leftStraight = 0;
        int rightStraight = 0;
        if (left != null && left.val == root.val) {
            leftStraight = leftPath + 1;
        }
        if (right != null && right.val == root.val) {
            rightStraight = rightPath + 1;
        }
        ans = Math.max(ans, leftStraight + rightStraight);
        return Math.max(leftStraight, rightStraight);
    }
}