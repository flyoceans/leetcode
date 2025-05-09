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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val == target) {
            TreeNode tmp = root.right;
            root.right = null;
            return new TreeNode[]{root, tmp};
        } else if (root.val < target) {
            TreeNode[] tmp = splitBST(root.right, target);
            root.right = tmp[0];
            return new TreeNode[]{root, tmp[1]};
        } else {
            TreeNode[] tmp = splitBST(root.left, target);
            root.left = tmp[1];
            return new TreeNode[]{tmp[0], root};
        }
        
    }
}