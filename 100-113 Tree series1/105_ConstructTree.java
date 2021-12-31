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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode buildTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL > preR || inL > inR)
            return null;
        int val = pre[preL];
        TreeNode root = new TreeNode(val);
        int len = findVal(in, val, inL, inR);
        root.left = buildTree(pre, preL+1, preL+len, in, inL, inL+len-1);
        root.right = buildTree(pre, preL+len+1, preR, in, inL+len+1, inR);
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