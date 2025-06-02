class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        int[] letters = new int[26];
        for (char c : p.toCharArray()) {
            letters[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            window[s.charAt(i) - 'a']++;
            if (isAnagram(window, letters)) {
                res.add(0);
            }
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - p.length()) - 'a']--;
            if (isAnagram(window, letters)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }

    private boolean isAnagram(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    
}