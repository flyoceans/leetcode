class Solution {
    public int divide(int dividend, int divisor) {
        // corner cases
        // 最小值取正数时会溢出。
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == dividend) // 情况1 min/min；
            return 1;
        if (divisor == Integer.MIN_VALUE) //情况2 ../min;
            return 0;
        int res = 0;
        if (dividend == Integer.MIN_VALUE) { //情况3 min/..;
            dividend += Math.abs(divisor);
            res++;
        }
        int sign = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? -1 : 1;
        int dividend_abs = Math.abs(dividend);
        int divisor_abs = Math.abs(divisor);
        res = sign *(res + helper(dividend_abs, divisor_abs));
        return res;
    }
    
    private int helper(int dividend, int divisor) {
        if (dividend < divisor)
            return 0;
        int times = 1;
        int divisor_tmp = divisor;
        while (dividend > (divisor_tmp << 1)) { //位操作会溢出留意！
            if ((divisor_tmp << 1) < 0) break;
            divisor_tmp <<= 1;
            times <<= 1;
        }
        dividend -= divisor_tmp;
        // divisor += times;
        return times + helper(dividend, divisor);
    }
}