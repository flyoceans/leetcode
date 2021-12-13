class Solution {
    // O(nlogn)
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > list.get(list.size() - 1)) list.add(nums[i]);
            else {
                int idx = binarySearch(list, nums[i]);
                // System.out.println(idx);
                list.set(idx, nums[i]);
            }
        }
        return list.size();
    }
    
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        
        while (left + 1 < right) {
            int mid = (left + right)/2;
            if (list.get(mid) == target) return mid;
            else if (list.get(mid) > target) right = mid;
            else left = mid;
        }
        if (target > list.get(left)) return right;
        else return left;
    }
}