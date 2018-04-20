class Solution {
    private int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return helper(1, n);
    }
    
    private int helper(int i, int j) {
        if (i >= j)
            return 0;
        if (i + 1 > j)
            return i;
        if (dp[i][j] != 0)
            return dp[i][j];
        int tmp = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            tmp = Math.min(tmp, k + Math.max(helper(i, k-1), helper(k+1, j)));
        }
        dp[i][j] = tmp;
        return dp[i][j];
    }
}