class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
//         int[] left = new int[nums.length];
//         Arrays.fill(left, 1);
//         int[] right = new int[nums.length];
//         Arrays.fill(right, 1);
//         for (int i = 1; i < n; i++) {
//             left[i] = left[i-1] * nums[i-1];
//         }
//         for (int i = n-2; i >= 0; i--) {
//             right[i] = right[i+1] * nums[i+1];
//         }
        
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++)
//             res[i] = left[i] * right[i];
        
//         return res;
        
        // O(1) space
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) left = res[i-1] * nums[i-1];
            res[i] = left;
        }
        
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) right *= nums[i+1];
            res[i] = res[i] * right;
        }
        
        return res;
    }
}