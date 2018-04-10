class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = (dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]) % mod;
                } else {
                    int l = i+1, r = j-1;
                    while (l <= r && S.charAt(l) != S.charAt(i)) l++;
                    while (l <= r && S.charAt(r) != S.charAt(j)) r--;
                    dp[i][j] = (2*dp[i+1][j-1]) % mod;
                    if (l > r) {
                        dp[i][j] = (dp[i][j] + 2) % mod;
                    } else if (l == r) {
                        dp[i][j] = (dp[i][j] + 1) % mod;
                    } else if (l + 1 < r) {
                        dp[i][j] = (dp[i][j] - dp[l+1][r-1]) % mod;
                    }
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[0][n-1];
    }
}