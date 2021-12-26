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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode mark = null, end = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode t = stack.pop();
                if (pre != null) {
                    if (pre.val > t.val) {
                        if (mark == null)
                            mark = pre;
                        end = t;
                    }  
                } 
                pre = t;
                root = t.right;
            }
        }
        if (mark != null) {
            int tmp = mark.val;
            mark.val = end.val;
            end.val = tmp;
        }
        return;
    }
}