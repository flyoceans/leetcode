class Solution {
    public List<String> generatePalindromes(String s) {
        
        List<String> ans = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        String mid = "";
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += (map.get(c) % 2 == 0 ? -1 : 1);
        }
        if (odd > 1)
            return ans;
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int num = entry.getValue();
            if (num % 2 != 0)
                mid += c;
            
                for (int i = 0; i < num/2; i++) {
                    list.add(c);
                } 
            
        }
        
        helper(ans, list, mid, new StringBuilder(), new boolean[list.size()]);
        
        return ans;
    }
    
    private void helper(List<String> ans, List<Character> list, String mid, StringBuilder sb, boolean[] used) {
        if (sb.length() == list.size()) {
            String tmp = sb.toString() + mid + sb.reverse().toString();
            ans.add(tmp);
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i-1) == list.get(i) && !used[i-1])
                continue;
            if (used[i])
                continue;
            used[i] = true;
            sb.append(list.get(i));
            helper(ans, list, mid, sb, used);
            sb.deleteCharAt(sb.length()-1);
            used[i] = false;
        }
        return;
    }
}