class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = {0, 0};
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        xor &= (-xor);
        for (int n : nums) {
            if ((n & xor) != 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
}