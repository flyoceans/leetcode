class Solution {
    public void wiggleSort(int[] nums) {
        findKthSmallestNum(nums, nums.length/2, 0, nums.length-1);

        int[] copy = Arrays.copyOf(nums, nums.length);
   
        int j = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[j++];
        }

        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[j++];
        }
        
    }

    private void findKthSmallestNum(int[] nums, int k, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, k, left, right);
        if (p == k) return;
        else if (p < k) findKthSmallestNum(nums, k, p+1, right);
        else findKthSmallestNum(nums, k, left, p-1);
    }

    private int partition(int[] nums, int k, int left, int right) {
        int pIndex = left + (right - left)/2;
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);

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

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}