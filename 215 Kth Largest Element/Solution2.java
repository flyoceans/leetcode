class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;

        quickSelect(nums, k, 0, nums.length-1);
        // System.out.println(Arrays.toString(nums));
        return nums[k];
    }
    
    private void quickSelect(int[] nums, int k, int left, int right) {
        if (left >= right) return;
        
        int p = partition(nums, left, right); // return index of pivot
        if (p == k) return;
        else if (p < k) quickSelect(nums, k, p+1, right);
        else quickSelect(nums, k, left, p-1);
    }
    
    int partition(int[] nums, int left, int right) {
        int pivotIndex = (left + right)/2;
        // int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int l = left, r = right-1;
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