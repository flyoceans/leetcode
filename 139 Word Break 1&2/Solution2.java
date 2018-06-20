class Solution {
    // 用普通DFS搜索会 TLE
    
    Map<String, List<String>> mem;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        mem = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set);
    }
    
    private List<String> wordBreak(String s, Set<String> dict) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            ans.add("");
            return ans;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String right = s.substring(i);
            if (!dict.contains(right)) {
                continue;
            }
            List<String> leftList = wordBreak(s.substring(0, i), dict);
            if (leftList.size() == 0) {
                continue;
            }
            for (String left : leftList) {
                String tmp = (left == "") ? right : left + " " + right;
                ans.add(tmp);
            }
        }
        mem.put(s, ans);
        return ans;
    }
    
}