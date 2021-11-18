class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
        
   private int robHelper(int[] nums, int start, int end) {
        int curr, prev, prev2;
        curr = prev = prev2 = 0;
        for (int i = start; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}