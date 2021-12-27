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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        if (shouldRemove(root)) return null;
        return root;
    }
    
    boolean shouldRemove(TreeNode t) {
        if (t == null) return true;
        
        boolean left = shouldRemove(t.left);
        boolean right = shouldRemove(t.right);
        
        if (left) t.left = null;
        if (right) t.right = null;
        return t.val == 0 && left && right;
    }
}