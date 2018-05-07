/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 不好用levelorder，因为加入有顺序
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        helper(res, root.left, true, false);
        helper(res, root.right, false, true);
        return res;
    }
    
    private void helper(List<Integer> res, TreeNode t, boolean isLeft, boolean isRight) {
        if (t == null)
            return;
        if (isLeft) {
            res.add(t.val);
            helper(res, t.left, true, false);
            helper(res, t.right, t.left == null, false);
        }
        if (!isLeft && !isRight) {
            if (t.left == null && t.right == null)
                res.add(t.val);
            helper(res, t.left, false, false);
            helper(res, t.right, false, false);
        }
        if (isRight) {
            helper(res, t.left, false, t.right == null);
            helper(res, t.right, false, true);
            res.add(t.val);
        }
    }
}