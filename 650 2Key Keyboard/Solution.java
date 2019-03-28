class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[j] + i/j, dp[i]);
                    dp[i] = Math.min(dp[i/j] + j, dp[i]);
                }
            }
        }
        
        return dp[n];
    }
}