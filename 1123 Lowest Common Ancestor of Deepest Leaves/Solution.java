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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // recursive func
        // current level
        // return to uppper
        // (LCA, height)
        Pair<TreeNode, Integer> res = dfs(root);
        
        return res.getKey();
    }

    Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) 
            return new Pair<>(null, 0);
        
        Pair<TreeNode, Integer> leftRes = dfs(root.left);
        Pair<TreeNode, Integer> rightRes = dfs(root.right);

        if (leftRes.getValue() > rightRes.getValue()) {
            return new Pair<>(leftRes.getKey(), leftRes.getValue() + 1);
        } else if (leftRes.getValue() < rightRes.getValue()) {
            return new Pair<>(rightRes.getKey(), rightRes.getValue() + 1);
        } else {
            return new Pair<>(root, leftRes.getValue() + 1);
        }


    }
}