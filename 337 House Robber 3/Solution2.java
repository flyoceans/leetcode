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
    // Bottom up recursive
    
    public int rob(TreeNode root) {
        Pair ans = bottomUp(root);
        return Math.max(ans.robRoot, ans.notRobRoot);
    }
    
    public Pair bottomUp(TreeNode root){
        if (root == null)
            return new Pair(0,0);
        
        if (root.left == null && root.right == null)
            return new Pair(root.val,0);
        
        Pair left = bottomUp(root.left);
        Pair right = bottomUp(root.right);
        
        int robRoot = root.val + left.notRobRoot + right.notRobRoot;
        int notRobRoot = Math.max(left.robRoot, left.notRobRoot) + Math.max(right.robRoot,right.notRobRoot);
        
       return new Pair(robRoot, notRobRoot);
        
    }
    
    
    class Pair {
        int robRoot;
        int notRobRoot;
        public Pair(int robRoot, int notRobRoot){
            this.robRoot = robRoot;
            this.notRobRoot = notRobRoot;
        }
    }
}
