class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        int pos = 0, neg = 0, max = Integer.MIN_VALUE;
        int prePos = 0, preNeg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                if (prePos != 0) pos = prePos*nums[i];
                else pos = nums[i];
                if (preNeg != 0) neg = preNeg*nums[i];
                else neg = 0;
            } else {
                if (preNeg != 0) pos = preNeg*nums[i];
                else pos = 0;
                if (prePos != 0) neg = prePos*nums[i];
                else neg = nums[i];
            }
            max = Math.max(max, pos);
            prePos = pos;
            preNeg = neg;
        }
        return max;
    }
}