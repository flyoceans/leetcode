class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start)/2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        for (int i = start, j = mid+1; i <= mid; i++) {
            while (j <= end && nums[i]/2.0 > nums[j]) {
                j++;
            }
            cnt += j - mid - 1;
        }
        merge(nums, start, mid, end);
        return cnt;
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid+1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
       
        for (k = 0; k < tmp.length; k++) {
            nums[start+k] = tmp[k];
        }
    }
    
    
}