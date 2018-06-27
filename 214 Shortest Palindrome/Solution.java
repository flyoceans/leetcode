class Solution {
    public String shortestPalindrome(String s) {
        // brute force
        // String reverse = new StringBuffer(s).reverse().toString();
        // int i = 0, len = s.length();
        // if (reverse.equals(s))
        //     return s;
        // while (i < len) {
        //     if (s.substring(0, len-i).equals(reverse.substring(i, len)))
        //         return reverse.substring(0, i) + s;
        //     i++;
        // }
        // return "";
        if (s == null || s.length() == 0)
            return s;
        KMP kmp = new KMP(s);
        String reverse = new StringBuffer(s).reverse().toString();
        int index = kmp.search(reverse);
        return reverse.substring(0, reverse.length()-index) + s;
    }
    
    class KMP {
        private String pat;
        private int[][] dfa;
        
        public KMP(String pat) {
            this.pat = pat;
            int M = pat.length();
            int R = 256;
            dfa = new int[R][M];
            dfa[pat.charAt(0)][0] = 1;
            for (int X = 0, j = 1; j < M; j++) {
                for (int i = 0; i < R; i++) {
                    dfa[i][j] = dfa[i][X];
                }
                dfa[pat.charAt(j)][j] = j+1;
                X = dfa[pat.charAt(j)][X];
            }
        }
        
        public int search(String txt) {
            int i, j, N = txt.length(), M = pat.length();
            for (i = 0, j = 0; i < N && j < M; i++) {
                j = dfa[txt.charAt(i)][j];
            }
            // if (j == M) return i - M;
            // else return N;
            return j;
        }
    }
}