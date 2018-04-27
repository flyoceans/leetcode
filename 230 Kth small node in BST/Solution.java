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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        int left = count(root.left);
        if (k == left + 1) {
            return root.val;
        } else if (k < left + 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }
    
    private int count(TreeNode t) {
        if (t == null)
            return 0;
        return 1 + count(t.left) + count(t.right);
    }
}