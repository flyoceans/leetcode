class Solution {
    // brute force, O(n * L)
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < word.length() && c == word.charAt(i)) i++;

            if (i == word.length() && word.length() >= res.length()) 
                if (word.length() > res.length() || word.compareTo(res) < 0)
                    res = word;
        }
        return res;
    }
}