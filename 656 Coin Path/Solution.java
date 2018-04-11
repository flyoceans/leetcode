class Solution {
    //耗时两小时，类似于猴子过河问题但难点在于求lexicographically smallest order
    //一开始正常dp,通过path[i] = i-j来记录path发现行不通。这个path要求太诡异了。
    //修改dp. 
    // dp[i] 为从i点开始到终点的cost，这样在min cost前提下一定能取到path最小的路径
    // dp[i] = min(dp[i+j] + A[i]) for-each 0< j <= B
    
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0 || A[A.length-1] == -1)
            return res;
        int n = A.length;
        int[] dp = new int[n];
        int[] path = new int[n];
        dp[n-1] = A[n-1];
        path[n-1] = n;
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            if (A[i] == -1)
                continue;
            for (int j = B; j > 0; j--) {       //此处一定要从大到小
                if (i + j < n && A[i+j] != -1 && dp[i+j] + A[i] <= dp[i]) {
                    dp[i] = dp[i+j] + A[i];
                    path[i] = i+j;
                }
            }
            if (dp[i] == Integer.MAX_VALUE)
                return res;
        }
        
        int k = 0;
        while (k < n) {
            res.add(k+1);
            k = path[k];
        }

        return res;
    }
}