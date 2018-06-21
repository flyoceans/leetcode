class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() !=  t.length())
            return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int si = smap.getOrDefault(s.charAt(i), -1);
            int ti = tmap.getOrDefault(t.charAt(i), -1);
            // if(map_s.getOrDefault(s.charAt(i), -1) != map_t.getOrDefault(t.charAt(i), -1))  didn't work!!!
            // because map.get() would return an Object, while using == or != to compare Object is not recommended.
            if (si != ti)
                return false;
            smap.put(s.charAt(i), i);
            tmap.put(t.charAt(i), i);
        }
        return true;
    }
}