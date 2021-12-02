// https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-790-domino-and-tromino-tiling/
class Solution {
    // dp[i][0] = dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-1][2]
    // dp[i][1] = dp[i-2][0] + dp[i-1][2]
    // dp[i][2] = dp[i-2][0] + dp[i-1][1]
    
    // dp[i][0] = dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]
    // dp[i][1] = dp[i-2][0] + dp[i-1][1]
    public int numTilings(int n) {
        long[][] dp = new long[n+1][2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]) % 1_000_000_007;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1]) % 1_000_000_007;
        }
        return (int)(dp[n][0] % 1_000_000_007);
    }
}