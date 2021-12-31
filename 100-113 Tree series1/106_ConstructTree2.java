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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null)
            return null;
        return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] post, int postL, int postR, int[] in, int inL, int inR) {
        if (postL > postR || inL > inR)
            return null;
        int val = post[postR];
        TreeNode root = new TreeNode(val);
        int len = findVal(in, val, inL, inR);
        root.left = buildTree(post, postL, postL+len-1, in, inL, inL+len-1);
        root.right = buildTree(post, postL+len, postR-1, in, inL+len+1, inR);
        return root;
    }
    
    private int findVal(int[] in, int val, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (in[i] == val)
                return (i - l);
        }
        return -1;
    }
}