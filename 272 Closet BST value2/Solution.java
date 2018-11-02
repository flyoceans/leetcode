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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        closest(root, target, k, res);
        return res;
    }
    
    public void closest(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) return;
        
        closest(root.left, target, k, res);
        if (res.size() < k) {
            res.add(root.val);
        } else if (Math.abs(res.get(0) - target) > Math.abs(root.val - target)) {
            res.remove(0);
            res.add(root.val);
        } else {
            return;
        }
        closest(root.right, target, k, res);
        return;
    }
}