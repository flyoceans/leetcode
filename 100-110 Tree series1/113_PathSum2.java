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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        dfs(root, res, sum, path);
        return res;
    }
    
    private void dfs(TreeNode t, List<List<Integer>> res, int sum, List<Integer> path) {
        if (t == null)
            return;
        
        if (t.left == null && t.right == null) {
            if (sum == t.val) {
                path.add(t.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(t.val);
        dfs(t.left, res, sum - t.val, path);
        // path.remove(path.size()-1);
        // path.add(t.val);
        dfs(t.right, res, sum - t.val, path);
        path.remove(path.size()-1);
    }
}