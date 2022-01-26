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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        Map<String, Integer> map = new HashMap<>();
        serialize(root, res, map);       
        return res;
    }
    // preorder serialization
    // Time O(n^2)
    // 1,2,4,#,#,#,3,2,4,#,#,#,4,#,#
    
    private String serialize(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null)
            return "#";
        
        String key = root.val + "," + serialize(root.left, res, map) + "," + serialize(root.right, res, map);

        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2)
            res.add(root);
        return key;
    }
}