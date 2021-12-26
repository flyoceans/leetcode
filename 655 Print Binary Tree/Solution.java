/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * //}
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) 
            return res;
        int h = getHeight(root);
        String[][] box = new String[h][(int)Math.pow(2, h) - 1];
        System.out.println(h);
        System.out.println((int)Math.pow(2, h) - 1);
        print(root, box, 0, (int)Math.pow(2, h-1) - 1, h-1);
        for (int i = 0; i < box.length; i++) {
            List<String> path = new ArrayList<>();
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] != null)
                    path.add(box[i][j]);
                else
                    path.add("");
            }
            res.add(path);
        }
        return res;
    }
    
    private void print(TreeNode t, String[][] box, int x, int y, int w) {
        if (t == null)
            return;
        box[x][y] = String.valueOf(t.val);
        print(t.left, box, x+1, y-(int)Math.pow(2,w-1), w-1);
        print(t.right, box, x+1, y+(int)Math.pow(2,w-1), w-1);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}