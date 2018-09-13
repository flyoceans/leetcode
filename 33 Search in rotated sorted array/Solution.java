class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length-1;
        while (l + 1 < r) {
            int mid = (l + r)/2;
            if (nums[l] > nums[mid]) {
               if (nums[mid] <= target && target <= nums[r]) {
                   l = mid;
               } else {
                   r = mid;
               }
            } else {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}