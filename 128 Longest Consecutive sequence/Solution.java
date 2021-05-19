class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        // set.addAll(Arrays.asList(nums));
        for (int i : nums) set.add(i);
        int res = 1;
        for (int i : set) {
            if (!set.contains(i-1)) {
                int tmp = i;
                while (set.contains(tmp+1)) {
                    tmp++;
                    res = Math.max(res, tmp - i + 1);
                }
            }
        }
        return res;
    }
}