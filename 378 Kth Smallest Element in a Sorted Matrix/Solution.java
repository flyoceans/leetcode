class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        int l = 0, r = sum;

        while (l + 1 < r) {
            int mid = l + (r - l)/2;
            if (cal(nums, mid) > k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (cal(nums, l) == k) return l;
        return r;
    }

    public int cal(int[] nums, int sum) {
        int res = 1, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sum) 
                return Integer.MAX_VALUE;
            if (curSum + nums[i] > sum) {
                curSum = 0;
                res++;
            }
            curSum += nums[i];
        }
        if (curSum > sum) res++;
        return res;
    }
}