class Solution {
    /**
     * 把每一位数都想成二进制的数，用一个32位的数组来记录每一位上面的1的count值。
     * 这里注意数组计数是从左往右走，而二进制数数是从右往左的。
     * 所以数组第0位的count就是二进制最低位上的count的。例如：4的二进制是000...000100，
     * 3个4的话按照每位相加的话，按照二进制表示法考虑就是300，数组（A[0]=0;A[1]=0;A[2]=3，然后后面到A[31]都得0）
     * 全部加完以后，对于数组上的每一位模3，加起来就是答案。
     *
     */

    public int singleNumber(int[] nums) {
        int[] res = new int[32];
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    res[j] ++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            a += ((res[i] % 3) << i);
        }
        return a;
    }
}