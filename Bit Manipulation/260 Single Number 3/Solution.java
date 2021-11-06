class Solution {
    // O(n), O(1)
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int i : nums) mask ^= i;
        int diff = mask & (~mask + 1);
        int x = 0;
        for (int i : nums) if ((i & diff) != 0) x ^= i;
        return new int[]{x, mask^x};
    }
}