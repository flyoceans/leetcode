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
    private boolean flag;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        // flag = true;
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode t, Integer min, Integer max) {
        if (t == null)
            return true;
        if (min != null && t.val <= min)
            return false;
        if (max != null && t.val >= max)
            return false;
        return isValidBST(t.left, min, t.val) && isValidBST(t.right, t.val, max);
    }
}