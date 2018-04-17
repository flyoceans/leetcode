class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null)
            return s1 == s2;
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int[] n = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            n[s1.charAt(i) - 'a'] ++; 
            n[s2.charAt(i) - 'a'] --; 
        }
        for (int i : n) {
            if (i != 0) return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(i, len), s2.substring(i, len)) && isScramble(s1.substring(0, i), s2.substring(0, i)))
                return true;
            if (isScramble(s1.substring(0, len-i), s2.substring(i, len)) && isScramble(s1.substring(len-i, len), s2.substring(0, i)))
                return true;
        }
        return false;
    }
}