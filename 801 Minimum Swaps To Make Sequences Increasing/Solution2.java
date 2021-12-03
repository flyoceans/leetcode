class Solution {
    // dp[i][0] min number of needed operations to reach index i, dont swap at index i
    // dp[i][1] swap at index i
    
    // if Math.min(nums1[i], nums2[i]) > Math.max(nums1[i-1], nums2[i-1]) means whether swap or not, forever strictly increasing
    // dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
    // dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
    // else if dont swap makes index i strictly increasing
    // else do swap makes index i strictly increasing
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        
        for (int i = 1; i < n; i++) {
            if (Math.min(nums1[i], nums2[i]) > Math.max(nums1[i-1], nums2[i-1])) {
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            }
            else if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1] + 1;
            } 
            else {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }
        // System.out.println(dp);
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}