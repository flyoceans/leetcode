class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n == 1)
            return Arrays.asList("0","1","8");
        List<String> ans = new ArrayList<>();
        char[] dict = {'0', '1', '8', '6', '9'};
        helper(ans, dict, new StringBuilder(), n);
        full(ans, n);
        return ans;
    }
    
    private void helper(List<String> ans, char[] dict, StringBuilder sb, int n) {
        if (sb.length() == (n+1)/2) {
            ans.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < dict.length; i++) {
            if (sb.length() == 0 && i == 0)
                continue;
            if (sb.length() == n/2 && (i == 4 || i == 3) && n % 2 == 1)
                continue;
            sb.append(dict[i]);
            helper(ans, dict, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    
    private void full(List<String> ans, int n) {
        int len = (n % 2 == 0) ? ans.get(0).length() : ans.get(0).length()-1;

        for (int i = 0; i < ans.size(); i++) {
            String str = ans.get(i);
            String rts = reverse(str, len);
            ans.set(i, str + rts);
        }
    }
    
    private String reverse(String s, int len) {
        String l = "";
        while (len > 0) {
            if (s.charAt(len-1) == '0' || s.charAt(len-1) == '1' || s.charAt(len-1) == '8') {
                l += s.charAt(len-1);
            } else {
                if (s.charAt(len-1) == '6') l += '9';
                else l += '6';
            }
            len--;
        }
        return l;
    }
}