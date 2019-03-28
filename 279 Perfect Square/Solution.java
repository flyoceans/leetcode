class Solution {
    public int numSquares(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}