class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null)
            return res;
        boolean[] visited = new boolean[nums.length];
        helper(res, nums, visited, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) 
                continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(res, nums, visited, path);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}