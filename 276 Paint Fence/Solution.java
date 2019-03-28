class Solution {
    
    public int numWays(int n, int k) {
    //     return (int)Math.pow(k-1, n-1)*k + (int)Math.pow(k-1, n-2) * (n - 1) * k;
        
        // num_i = diff_i-1 + same_i-1
        // diff_i-1 = num_i-1 * (k-1)
        // same_i-1 = diff_i-2 = num_i-2 * (k-1)
        if (k == 0 || n== 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k*k;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k*k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) * (k-1);
        }
        return dp[n];
    }

}