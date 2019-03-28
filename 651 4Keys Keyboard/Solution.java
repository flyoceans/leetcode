class Solution {
    public int maxA(int N) {
        // dp[i] = (i - 2 - j + 1) * dp[j]
        if (N == 0) return 0;
        
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
               dp[i] = Math.max(dp[i], dp[j] * (i - 2 - j + 1)); 
            }
            
        }
        return dp[N];
    }
}