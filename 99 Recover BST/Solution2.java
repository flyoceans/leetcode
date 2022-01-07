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
    
    TreeNode first = null, second = null, prev = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(first, second);
    }
    
     public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
      }
    
    public void inorder(TreeNode t) {
        if (t == null) return;
        
        inorder(t.left);
        
        if (first == null && prev != null && prev.val >= t.val) {
            first = prev;
        }
        if (first != null && prev != null && prev.val >= t.val) {
            second = t;
        }
        prev = t;
        
        inorder(t.right);
    }
}