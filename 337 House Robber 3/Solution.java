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
    Map<TreeNode, Integer> rob = new HashMap<>();
    Map<TreeNode, Integer> notRob = new HashMap<>();
    public int rob(TreeNode root) {
        return rob(root, false);
    }
    
    private int rob(TreeNode root, boolean parent) {
        if (root == null) return 0;
        // if (map.containsKey(root)) return map.get(root);
        int res = 0;
        if (parent) {
            if (rob.containsKey(root)) return rob.get(root);
            res = rob(root.left, false) + rob(root.right, false);
            rob.put(root, res);
        } else {
            if (notRob.containsKey(root)) return notRob.get(root);
            res = Math.max(root.val + rob(root.left, true) + rob(root.right, true), rob(root.left, false) + rob(root.right, false));
            notRob.put(root, res);
        }
        // map.put(root, res);
        return res;
    }
}