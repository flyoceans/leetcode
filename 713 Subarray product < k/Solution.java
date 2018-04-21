class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return 0;
        // int[] product = new int[nums.length];
        // product[0] = 1;
        // int res = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     product[i+1] = product[i]*nums[i];
        //     int tmp = product[i+1]/k;
        //     //Arrays.binarySearch(product)
        //     res += i - j;
        // }
        // return res;
        int res = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            res += j - i + 1;
        }
        return res;        
    }
    
    // private int binarySearch(int[] p, int l, int r, int target) {
    //     while (l + 1 < r) {
    //         int mid = (l + r)/2;
    //         if (p[mid] == target) {
    //             return mid;
    //         } else if (p[mid] > target) {
    //             r = mid;
    //         } else {
    //             l = mid;
    //         }
    //     }
    // }
}