class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[] x = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] y = {1, -1, 2, -2, 2, -2, 1, -1};
        double[][] dp = new double[N][N];
        
        for (int k = 0; k <= K; k++) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (k == 0) {
                        dp2[i][j] = 1;
                        continue;
                    }
                    for (int a = 0; a < 8; a++) {
                        if (i + x[a] >= 0 && i + x[a] < N && j + y[a] >= 0 && j + y[a] < N) {
                            dp2[i][j] += dp[i + x[a]][j + y[a]]/8;
                        }
                    }
                }
            }
            dp = dp2;
        }
        
        return dp[r][c];
    }
}