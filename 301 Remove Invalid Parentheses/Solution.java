class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        
        Set<String> res = new HashSet<>();
        dfs(res, "", left, right, 0, s);
        return new ArrayList<>(res);
    }
    
    void dfs(Set<String> res, String cur, int left, int right, int idx, String s) {
        if (idx == s.length()) {
            if (left == 0 && right == 0 && isValid(cur)) res.add(new String(cur));
            return;
        }
        char c = s.charAt(idx);

        if (c == '(' && left > 0) dfs(res, cur, left - 1, right, idx+1, s);
        if (c == ')' && right > 0) dfs(res, cur, left, right - 1, idx+1, s); 
        if (left == 0 && right == 0) {
            dfs(res, cur + s.substring(idx), left, right, s.length(), s);
            return;
        }
        dfs(res, cur + c, left, right, idx+1, s);
    
    }
    
    boolean isValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        return left == 0 && right == 0;
    }
}