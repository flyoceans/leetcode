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
    public int minDepth(TreeNode root) {
//         // BFS
//         if (root == null)
//             return 0;
//         if (root.left == null && root.right == null)
//             return 1;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int min = 1;
//         while (queue.size() != 0) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode tmp = queue.poll();
//                 if (tmp.left == null && tmp.right == null) 
//                     return min;
//                 if (tmp.left != null)
//                     queue.add(tmp.left);
//                 if (tmp.right != null)
//                     queue.add(tmp.right);
//             }
//             min++;
//         }
        
//         return min;
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;

    }
}