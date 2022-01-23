class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, nums.length - k, 0, nums.length-1);
        return nums[nums.length - k];
    }
    
    private void quickSelect(int[] nums, int k, int left, int right) {
        if (left >= right) return;
        
        int mid = partition(nums, left, right);
        if (mid == k) return;
        else if (mid < k) quickSelect(nums, k, mid+1, right);
        else quickSelect(nums, k, left, right - 1);
    }
    
    int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        
        int l = left, r = right - 1;
        while (l <= r) {
            while (l <= r && nums[l] <= pivot) l++;
            while (l <= r && nums[r] > pivot) r--;
            if (l < r)
                swap(nums, l, r);
        }
        swap(nums, right, l);
        return l;
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}