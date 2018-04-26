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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r)
            return null;
        if (l == r)
            return new TreeNode(nums[l]);
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode t = new TreeNode(max);
        t.left = helper(nums, l, maxIndex-1);
        t.right = helper(nums, maxIndex+1, r);
        return t;
    }
}