/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 解法类似 687
class Solution {
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    
    private boolean helper(TreeNode root) {
        if (root == null)
            return true;
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right && 
            (root.left == null || root.left.val == root.val) &&
            (root.right == null || root.right.val == root.val)) {
            ans++;
            return true;
        }
        
        return false;
    }
}