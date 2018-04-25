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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, res, 0);
        Collections.reverse(res);
        return res;
    }
    
    private void helper(TreeNode t, List<List<Integer>> res, int lv) {
        if (t == null)
            return;
        if (res.size() <= lv) {
            res.add(new ArrayList<Integer>());
        }
        res.get(lv).add(t.val);
        helper(t.left, res, lv+1);
        helper(t.right, res, lv+1);
    }
}