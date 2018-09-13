class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int l = 0, r = nums.length-1;
        while (l + 1 < r) {
            int mid = (l + r)/2;
            if (nums[mid] == target)
                return true;
            //tricky!
            if( (nums[l] == nums[mid]) && (nums[r] == nums[mid]) ) {++l; --r;}
            else if (nums[l] > nums[mid]) {
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
        if (nums[l] == target) return true;
        if (nums[r] == target) return true;
        return false;
    }
}