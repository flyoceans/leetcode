class Solution {
    public int findKthLargest(int[] nums, int k) {
        return sort(nums, nums.length - k, 0, nums.length-1);
    }
    
    int sort(int[] nums, int k, int l, int r) {
        if (l == r) return nums[l];
        int start = l, end = r;
        int pivot = nums[l++];
        
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) swap(nums, l, r);
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, start, r);
        if (k == r) return nums[r];
        else if (k < r) return sort(nums, k, start, r);
        else return sort(nums, k, r+1, end);
    }
    
    void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}