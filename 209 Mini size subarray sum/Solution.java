class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // sliding window
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE, len = nums.length;
        int sum = 0;
        while (right < len) {
            if (sum >= s) {
                min = Math.min(right - left, min);
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }
        }
        while (sum >= s) {
            min = Math.min(right - left, min);
            sum -= nums[left];
            left++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}