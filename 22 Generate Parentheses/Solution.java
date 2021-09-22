class Solution {
    // dfs
    // next step? move index pointer 
    // state? either ( or )
    // add answer if reaches the length
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n, n);
        return res;
    }
    
    
    void dfs(List<String> res, String cur, int left, int right, int n) {
        if (left < 0 || right < 0 || left > right) return;
        if (cur.length() == n * 2) {
            res.add(new String(cur));
            return;
        }
        
        // if (left < 0 || right < 0 || left > right) return;
        dfs(res, cur + "(", left - 1, right, n);
        dfs(res, cur + ")", left, right - 1, n);
        return;
    }
}