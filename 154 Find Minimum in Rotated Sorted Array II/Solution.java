class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while (l + 1 < r) {
            int mid = (r - l)/2 + l;
            if (nums[l] < nums[mid] && nums[mid] < nums[r]) {
                return nums[l];
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] > nums[l]) {
                r = mid;
            } else {
                l++;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}