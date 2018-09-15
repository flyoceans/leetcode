class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (Math.abs(sl - tl) > 1) return false;
       
        for (int i = 0; i < Math.min(sl, tl); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sl == tl) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if (sl > tl) {
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return t.substring(i+1).equals(s.substring(i));
                }
            }
        }
        return  Math.abs(sl - tl) == 1;
    }
}