class Solution {
    // String 问题corner case 
    // "01" 0开头无效数字
    // "10" 0无效
    // “12353454564” 巨大数越界
    // 关于Integer.valueOf() 和 Integer.parseInt() 内部实现是一样的
    // https://blog.csdn.net/suifeng3051/article/details/52101411
    public int numDecodings(String s) {
         if (s.charAt(0) - '0' <= 0)
            return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            Integer c = Integer.valueOf(s.charAt(i) - '0');
            if (c > 0)
                dp[i+1] = dp[i];
            if (i - 1 >= 0 && helper(s.substring(i-1, i+1)) && Integer.valueOf(s.charAt(i-1) - '0') > 0)
                dp[i+1] += dp[i-1];
        }
    
        return dp[len];
    }
    
    private boolean helper(String s) {
        return (Integer.valueOf(s) <= 26 && Integer.valueOf(s) > 0);
    }
}