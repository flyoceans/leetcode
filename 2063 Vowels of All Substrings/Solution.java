class Solution {
    public long countVowels(String word) {
        long res = 0;
        long n = word.length();
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        for (int i = 0; i < n; i++) {
            if (set.contains(word.charAt(i))) res += (i + 1) * (n - i);
        }
        return res;
    }
}
 