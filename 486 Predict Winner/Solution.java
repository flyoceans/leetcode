class Solution {
    
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                    continue;
                }
                int a = nums[i] - dp[i+1][j];
                int b = nums[j] - dp[i][j-1];
                dp[i][j] = Math.max(a,b);
            }
        }
        return dp[0][n-1] >= 0;
    }
    
    //miniMax algo.
    /**
        miniMax(s)
            if terminate(s) return utility(s)
            if player == MAX 
                max(for all action of miniMax(result(s, action)))     
            if player == MIN
                min(for all action of miniMax(result(s, action)))
    **/
//     public boolean PredictTheWinner(int[] nums) {
//         if (nums == null || nums.length == 0)
//             return false;
//         return miniMax(nums, 0, nums.length-1, 1) >= 0;
//     }
    
//     private int miniMax(int[] nums, int s, int e, int turn) {
//         if (s == e)
//             return nums[s]*turn;
        
//         if (turn == 1) {
//             return Math.max(nums[s] + miniMax(nums, s+1, e, -turn), nums[e] + miniMax(nums, s, e-1, -turn));
//         } else {
//             return Math.min(nums[s]*turn + miniMax(nums, s+1, e, -turn), nums[e]*turn + miniMax(nums, s, e-1, -turn));
//         }
//     }
    
    
    
}