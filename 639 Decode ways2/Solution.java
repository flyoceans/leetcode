class Solution {
    public int numDecodings(String s) {
//         if (s == null || s.length() == 0)
//             return 0;
//         if (Integer.parseInt(s.charAt(0) - '0') == 0)
//             return 0;
//         if (s.length() == 1)
//             return 1;
//         int[] dp = new int[s.length()+1];
//         dp[0] = 1;
//         for (int i = 0; i < s.length(); i++) {
//             if (isValid(s.charAt(i))) {
//                 dp[i+1] = dp[i];
//             }
//             if (i > 0 && isValid(s.charAt(i-1), s.charAt(i))) {
//                 dp[i+1] += dp[i-1];
//             }
//         }
//         return dp[s.length()];
//     }
    
//     private boolean isValid(char a) {
//         return Integer.parseInt(a - '0') > 0;
//     }
    
//     private boolean isValid(char a, char b) {
//         int pre = Integer.parseInt(a - '0');
//         int post = Integer.parseInt(b - '0');
//         int res = a*10 + b;
//         return (res > 9) && (res <= 26);
//     }
        /* initial conditions */
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        /* bottom up method */
        for(int i = 2; i <= s.length(); i++){
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            // For dp[i-1]
            if(second == '*'){
                dp[i] += 9*dp[i-1];
            }else if(second > '0'){
                dp[i] += dp[i-1];
            }
            
            // For dp[i-2]
            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15*dp[i-2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                       dp[i] += 9*dp[i-2]; 
                    }else{ // first == '2'
                       dp[i] += 6*dp[i-2]; 
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];    
                }
            }

            dp[i] %= 1000000007;
        }
        /* Return */
        return (int)dp[s.length()];
    }
}