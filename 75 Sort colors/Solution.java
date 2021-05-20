class Solution {
    // 3-way partition quick sort
    public void sortColors(int[] nums) {
        int lo = 0, i = 0, hi = nums.length-1;
        while (i <= hi) {
            if (nums[i] == 0) {
                swap(nums, lo, i);
                lo++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, hi);
                hi--;
            } else {
                i++;
            }
        }
    }
    
    void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}