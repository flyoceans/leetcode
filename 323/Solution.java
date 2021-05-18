class Solution {
    // backpack problem;
    // dp[i] means the fewest number of coins when amount is i.
    // dp[i] = min(dp[i - coin[j]] + 1) for-each j. Initialize as -∞ if cannout be denominated by any combination of coins.
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}