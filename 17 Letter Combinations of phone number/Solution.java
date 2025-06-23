class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        dfs(res, new StringBuilder(), 0, digits);
        return res;
    }
    
    void dfs(List<String> res, StringBuilder cur, int pos, String digits) {
        if (pos == digits.length()) {
            res.add(cur.toString());
            return;
        }
        
        // String letters = dict[Character.getNumericValue(digits.charAt(pos))];
        String possbileLetters = letters.get(digits.charAt(pos));
        for (char letter : possbileLetters.toCharArray()) {
            cur.append(letter);
            dfs(res, cur, pos+1, digits);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    
    // final String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private Map<Character, String> letters = Map.of(
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );

}