class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i-1) == '(') 
                        dp[i] = (i-2 <= 0 ? 2 : dp[i-2] + 2);
                    else 
                        if (i - dp[i-1] -1 >= 0 && s.charAt(i - dp[i-1]-1) == '(')
                            dp[i] = (i- dp[i-1] -2 <= 0 ? 0: dp[i- dp[i-1] -2]) + dp[i-1] + 2;
                }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}