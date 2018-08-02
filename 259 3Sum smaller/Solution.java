class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int k = nums.length-1; k > 1; k--) {
            int i = 0, j = k-1;
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    j--;
                } else {
                    ans += j - i;
                    i++;
                }
            }
        }
        return ans;
    }
}