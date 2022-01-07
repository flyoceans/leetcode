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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                TreeNode tmp = root.right;
                root.right = null;
                return tmp;
            } 
            if (root.right == null) {
                TreeNode tmp = root.left;
                root.left = null;
                return tmp;
            }
            TreeNode left = root.left;
            while (left.right != null) left = left.right;
            
            root.val = left.val;
            root.left = deleteNode(root.left, left.val);
        }
        
        return root;
    }
}