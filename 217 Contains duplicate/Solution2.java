class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = i - map.getOrDefault(nums[i], i);
            if (diff > 0 && diff <= k) 
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}