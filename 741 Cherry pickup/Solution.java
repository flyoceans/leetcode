class Solution {
    //没想出来，看了solution。
    //一开始用贪心跑两遍，遇到了counter case
    // 11100
    // 00101
    // 10100
    // 00111
    // 切回dp。思路是两个点同时走到下一个状态，于是有四种情况：
    //          Person 1 down and person 2 down: dp[r1+1][c1][c2];
    //          Person 1 right and person 2 down: dp[r1][c1+1][c2];
    //          Person 1 down and person 2 right: dp[r1+1][c1][c2+1];
    //          Person 1 right and person 2 right: dp[r1][c1+1][c2+1];
    // 由于两个点的步数都是一样的【0, 2*(n-1)】,因此只需要r1,c1,c2就可以知道r2。
    // 从[0,0]开始搜
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] layer: dp)
            for (int[] row: layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        return Math.max(0, helper(dp, grid, 0, 0, 0));
    }
    
    public int helper(int[][][] dp, int[][] grid, int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (grid.length == r1 || grid.length == r2 || grid.length == c1 || grid.length == c2 ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -9999;        
        } else if (r1 == grid.length-1 && c1 == grid.length-1) {
            return grid[r1][c1];
        } else if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][c2];
        } else {
            int ans = grid[r1][c1];
            if (c1 != c2) ans += grid[r2][c2];
            ans += Math.max(Math.max(helper(dp, grid, r1, c1+1, c2+1), helper(dp, grid, r1+1, c1, c2+1)),
                            Math.max(helper(dp, grid, r1, c1+1, c2), helper(dp, grid, r1+1, c1, c2)));
            dp[r1][c1][c2] = ans;
            return ans;
        }
    }
}