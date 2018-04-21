class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 暴力解法 2维dp超时
        // continuous subarray一般考虑prefix
        // S[j] - S[i] = nk
        // S[j] % k = S[i]
        if (nums == null || nums.length < 2)
            return false;
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = nums[i];
//         }
//         for (int j = 1; j < nums.length; j++) {
//             for (int i = 0; i < j; i++) {
//                 dp[i][j] = dp[i][j-1] + nums[j];
                
//                 if (k == 0) {
//                     if (dp[i][j] == 0)
//                         return true;
//                 } else {
//                     if (dp[i][j] % k == 0)
//                         return true;
//                 }
//                 if (dp[i][j] < k)
//                     break;
//             }
//         }
//         return false;
        if (k == 0) {
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] == 0 && nums[i+1] == 0)
                    return true;
            }
            return false;
        }
        // if (k < 0) k *= -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) 
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}