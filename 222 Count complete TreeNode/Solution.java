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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = left(root);
        int right = right(root);
        if (left == right)
            return (1 << left) - 1;
        else 
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int left(TreeNode root) {
        int ans = 0;
        while (root != null) {
            root = root.left;
            ans++;
        }
        return ans;
    }
    
    private int right(TreeNode root) {
        int ans = 0;
        while (root != null) {
            root = root.right;
            ans++;
        }
        return ans;
    }
}