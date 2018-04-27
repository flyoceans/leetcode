/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 虽然是easy题但是踩了好几个坑
 * 1，一开始没读完题，直接dfs取第二
 * 2， 感觉treeNode是从上到下递增的这个条件可能可以剪枝，实际上没用。第二小的可以是最下的leaf
 * 3，level order 
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                if (tmp.val > root.val && tmp.val < max) 
                    max = tmp.val;
            }
           
        }
         if (max > root.val && max != Integer.MAX_VALUE)
                return max;
        return -1;
    }
}