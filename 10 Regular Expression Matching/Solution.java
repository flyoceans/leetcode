class Solution {
// 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
// 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
// 3, If p.charAt(j) == '*': 
//    here are two sub conditions:
//                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//                2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
//                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
//                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j-1) == '*' && j - 2 >= 0)
                dp[0][j] = dp[0][j-2];
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.')
                        dp[i][j] = dp[i][j-2];
                    else if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        dp[i][j] = (dp[i-1][j] | dp[i][j-1]);
                        if (j >= 2)
                            dp[i][j] |= dp[i][j-2];
                    }
                    
                } else {
                    dp[i][j] = 0;
                }             
            }
        }
        
        return dp[m][n] == 1;
    }
}