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
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        TreeNode first = null, second = null;
        
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode t = stack.pop();
                if (first == null && pre != null && pre.val >= t.val) {
                    first = pre;
                } 
                if (first != null && pre.val >= t.val) {
                    second = t;
                }
                pre = t;
                root = t.right;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return;
    }
}