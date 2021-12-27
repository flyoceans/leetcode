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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (shouldRemove(root, target)) return null;
        return root;
    }
    
    boolean shouldRemove(TreeNode root, int target) {
        if (root == null) return true;
        
        boolean left = shouldRemove(root.left, target);
        boolean right = shouldRemove(root.right, target);
        
        if (left) root.left = null;
        if (right) root.right = null;
        return root.val == target && left && right;
    }
}