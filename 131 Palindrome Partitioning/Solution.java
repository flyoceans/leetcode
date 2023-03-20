
public class Solution {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0, new HashSet<>());
        return res;
    }
    
    private void backtrack(List<List<String>> res, List<String> path, String s, int pos, Set<String> palin) {
        if (pos == s.length()) {
            res.add(new ArrayList(path));
            return;
        }
        
        for (int i = pos + 1; i <= s.length(); i++) {
            String tmp = s.substring(pos, i);
            if (palin.contains(tmp) || isPalindrome(tmp, palin)) {
                path.add(tmp);
                backtrack(res, path, s, i, palin);
                path.remove(path.size()-1);
            }
        }
        
        return;
    }
    
    boolean isPalindrome(String str, Set<String> palin) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        palin.add(str);
        return true;
    }
}