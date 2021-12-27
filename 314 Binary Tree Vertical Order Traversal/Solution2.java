/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                map.putIfAbsent(p.col, new ArrayList<Integer>());
                map.get(p.col).add(p.t.val);
                
                if (p.t.left != null) {
                    q.add(new Pair(p.t.left, p.col - 1));
                    min = Math.min(p.col - 1, min);
                }
                if (p.t.right != null) {
                    q.add(new Pair(p.t.right, p.col + 1));
                    max = Math.max(p.col + 1, max);
                }
            }
        }
        for (int i = min; i <= max; i++) {      //we cannot use size() to determine the range cuz it may not be symmetrical.
            res.add(map.get(i));
        }
        return res;
    }
    
    class Pair {
        TreeNode t;
        int col;
        
        public Pair(TreeNode t, int v) {
            this.t = t;
            this.col = v;
        }
    }
}