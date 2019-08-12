class Solution {
    /**
    提供了一种BST的方法
    注意处理相等元素的办法。
    */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        
        TreeNode tree = new TreeNode(nums[nums.length-1]);
        res.add(0);
        for (int i = nums.length-2; i >= 0; i--) {
            res.add(insert(nums[i], tree));
        }
        Collections.reverse(res);
        return res;
    }
    
    private int insert(int val, TreeNode node) {
        if (node.val >= val) {
            node.equalOrSmall++;
            if (node.left == null) {
                node.left = new TreeNode(val);
                return 0;
            } else {
                return insert(val, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return node.equalOrSmall;
            } else {
                return node.equalOrSmall + insert(val, node.right);
            }
        }
    }
    
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int equalOrSmall;
        int val;
        public TreeNode(int x) {
            this.val = x;
            this.equalOrSmall = 1;
        }
    }
}