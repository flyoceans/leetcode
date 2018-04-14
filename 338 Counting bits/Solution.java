class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int local = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (local < 0) local = nums[i];
            else local += nums[i];
            max = Math.max(local, max);
        }
        return max;
    }
}