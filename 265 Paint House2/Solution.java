class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int min1 = 10000;
        int min2 = 10000;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                    if (dp[i][j] <= min1) {
                        min2 = min1;
                        min1 = dp[i][j];
                    } else if (dp[i][j] <= min2) {
                        min2 = dp[i][j];
                    }
                    continue;
                }
                if (dp[i-1][j] == min1)
                    dp[i][j] = min2 + costs[i][j];
                else 
                    dp[i][j] = min1 + costs[i][j];
            }
            min1 = 10000;
            min2 = 10000;
            for (int j = 0; j < k; j++) {
                if (dp[i][j] <= min1) {
                    min2 = min1;
                    min1 = dp[i][j];
                } else if (dp[i][j] <= min2) {
                    min2 = dp[i][j];
                }
            }
        }
        return min1;
    }
}