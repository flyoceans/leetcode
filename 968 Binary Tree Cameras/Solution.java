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
    int cameraCount=0;
    
    public enum Camera {
        NONE,
        CAMERA,
        COVERED;
    }
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == Camera.NONE) 
            cameraCount++;
        return cameraCount;
    }
    
    public Camera dfs(TreeNode root) {
        if (root == null)
            return Camera.COVERED;
        
        Camera left = dfs(root.left);
        Camera right = dfs(root.right);
        
        if (left == Camera.NONE || right == Camera.NONE) {
            cameraCount++;
            return Camera.CAMERA;
        }
        if (left == Camera.CAMERA || right == Camera.CAMERA) {
            return Camera.COVERED;
        }
        return Camera.NONE;
    }
}