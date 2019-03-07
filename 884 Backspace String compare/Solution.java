class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        char target1 = '\u0000';
        char target2 = '\u0000';
        int bs_s = 0;
        int bs_t = 0;
        while (i >= 0 || j >= 0) {
            
            while (i >= 0) {
                char s = S.charAt(i);
                if (s == '#') bs_s++;
                else if (bs_s > 0) bs_s--;
                else {
                    target1 = s;
                    break;
                }
                i--;
            }
            
            while (j >= 0) {
                char t = T.charAt(j);
                if (t == '#') bs_t++;
                else if (bs_t > 0) bs_t--;
                else {
                    target2 = t;
                    break;
                }
                j--;
            }

            if (target1 != target2) return false;
            target1 = '\u0000';
            target2 = '\u0000';
            i--;j--;
        }
        return true;
    }
}