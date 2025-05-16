class Solution {
    public boolean canPartition(int[] nums) {
        // 0/1 Knapback
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % 2 != 0) return false;
        Arrays.sort(nums);

        int[][] dp = new int[nums.length+1][sum/2 + 1];

        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < dp[0].length; j++) {
                if (j >= nums[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i-1]] + nums[i-1]);
                else 
                    dp[i][j] = dp[i-1][j];
            }
            
        }
        return dp[nums.length][sum/2] == sum/2;
    }
}