class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int l = 0, r = nums[nums.length - 1];
        
        while (l + 1 < r) {
            int mid = (l + r) >> 1;
            int cnt = countLessOrEqual(nums, mid);
            if (cnt < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (countLessOrEqual(nums, l) < k) return r;
        return l;
        
    }
    
    
    private int countLessOrEqual(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] <= target) j++;
            res += j - i - 1;
        }
        return res;
    }
}