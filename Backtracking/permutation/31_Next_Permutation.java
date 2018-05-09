class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        } 
        int min = Integer.MAX_VALUE, minIndex = nums.length-1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] < min && nums[i] > nums[index]) {
                min = nums[i];
                minIndex = i;
            }
        }
        swap(nums, minIndex, index);
        Arrays.sort(nums, index+1, nums.length);

    }
    
    private void swap(int[] n, int a, int b) {
        int tmp = n[a];
        n[a] = n[b];
        n[b] = tmp;
    }
}