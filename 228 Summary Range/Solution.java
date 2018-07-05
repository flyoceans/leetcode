class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < nums.length-1 && nums[i] + 1 == nums[i+1]) {
                continue;
            }
                String s = (i == j) ? nums[j] + "" : nums[j] + "->" + nums[i];
                j = i+1;
                ans.add(s);
        }
        // String last = (nums.length-1 == j) ? nums[j] + "" : nums[j] + "->" + (nums[nums.length-1]);
        // ans.add(last);
        return ans;
    }
}