class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        
        dfs(num, target, 0, "", 0, 0, res);
        
        return res;
    }
    
    
    private void dfs(String num, int target, // input
                     int pos, String exp, long prev, long cur, // state
                     List<String> res) {    // output
        if (pos == num.length()) {
            if (target == cur) res.add(exp);
            return;
        }
        
        for (int i = pos + 1; i <= num.length(); i++) {
            String s = num.substring(pos, i);
            
            if (s.charAt(0) == '0' && s.length() > 1) break;
            long n = Long.valueOf(s);
            if (n > Integer.MAX_VALUE) break;
            if (pos == 0) {
                dfs(num, target, i, s, n, n, res);
                continue;
            }
            dfs(num, target, i, exp + "+" + s, n, cur + n, res);
            dfs(num, target, i, exp + "-" + s, -n, cur - n, res);
            dfs(num, target, i, exp + "*" + s, prev * n, cur - prev + n * prev, res);
            
        }
        
    }
}