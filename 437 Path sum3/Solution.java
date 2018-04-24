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
    public int pathSum(TreeNode root, int sum) {
        // DFS 15%速度
//         if (root == null)
//             return 0;
//         return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//     }
    
//     private int pathSumFrom(TreeNode root, int localSum) {
//         if (root == null)
//             return 0;
//         int local = 0;
//         if (localSum == root.val) {
//             local += 1;
//         } 
        
//         local += pathSumFrom(root.left, localSum-root.val);
//         local += pathSumFrom(root.right, localSum-root.val);
//         return local;
        
        // 引入 HashSet 剪枝 6.2%速度
//         Set<TreeNode> isVisited = new HashSet<>();
//         return helper(root, sum, isVisited);
//     }
    
//     private int helper(TreeNode t, int sum, Set<TreeNode> isVisited) {
//         if (t == null)
//             return 0;
//         int res = (t.val == sum) ? 1 : 0;
//         if (!isVisited.contains(t)) {
//             isVisited.add(t);
//             res += helper(t.left, sum, isVisited);
//             res += helper(t.right, sum, isVisited);
//         }
//             res += helper(t.left, sum-t.val, isVisited);
//             res += helper(t.right, sum-t.val, isVisited);
//         return res;
        
        // prefix two sum 解法
        if (root == null)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }
    
    private int helper(TreeNode t, int sum, int target, Map<Integer, Integer> map) {
        if (t == null)
            return 0;
        sum += t.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += helper(t.left, sum, target, map) + helper(t.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}