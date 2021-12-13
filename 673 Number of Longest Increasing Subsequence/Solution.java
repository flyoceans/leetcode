class Solution {
    // LIS[i] length of LIS ending at index i
    // LIS[i] = max(LIS[j] + 1, LIS[i]), 0 <= j < i, nums[j] < nums[i]
    // NLIS[i] number of length of LIS[i]
    // NLIS[i] = 1 if new 
    // NLIS[i] ++ if LIS[i] = LIS[j]
    public int findNumberOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int[] NLIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        Arrays.fill(NLIS, 1);
        
        int max = 1, res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                        NLIS[i] = NLIS[j];
                    } else if (LIS[i] == LIS[j] + 1) {
                        NLIS[i] += NLIS[j];
                    }
                }
            }
            max = Math.max(LIS[i], max);
        }
        
        for (int i = 0; i < nums.length; i++) 
            if (max == LIS[i]) res += NLIS[i];
        return res;
    }
}