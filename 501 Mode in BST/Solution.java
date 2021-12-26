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
    private int max;
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0]; 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        max = 0;
        inorder(root, map); 
        
        List<Integer> list = new LinkedList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max) list.add(key);
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; i++) res[i] = list.get(i);
        return res; 
    }
    
    private void inorder(TreeNode node, HashMap<Integer, Integer> map){
        if(node.left!=null) 
            inorder(node.left, map);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max = Math.max(max, map.get(node.val));
        if(node.right!=null) 
            inorder(node.right, map); 
    }
    
}