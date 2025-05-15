class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane. max subarray sum
        int curSum = -1000_000;
        int maxSum = -1000_000;
        for (int i : nums) {
            curSum = Math.max(i, curSum + i);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}