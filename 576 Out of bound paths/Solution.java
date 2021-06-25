class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int mod = 1_000_000_007;
        int[][][] dp = new int[m][n][maxMove+1];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
 
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) dp[i][j][k] += 1;
                        else dp[i][j][k] = (dp[i][j][k] + dp[x][y][k-1]) % mod;
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}