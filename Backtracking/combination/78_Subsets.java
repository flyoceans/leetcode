class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        combination(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void combination(List<List<Integer>> res, List<Integer> curr, int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        combination(res, curr, nums, idx+1);
        curr.add(nums[idx]);
        combination(res, curr, nums, idx+1);
        curr.remove(curr.size() - 1);

    }
}