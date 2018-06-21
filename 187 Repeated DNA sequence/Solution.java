class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10)
            return ans;
        
//         Map<String, Integer> map = new HashMap<>();
//         for (int i = 0; i < s.length() - 9; i++) {
//             String tmp = s.substring(i, i+10);
//             if (map.containsKey(tmp) && map.get(tmp) == 1) {
//                 ans.add(tmp);
//             } 
//             map.put(tmp, map.getOrDefault(tmp, 0) + 1);   
            
//         }
//         return ans;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int cur = 0, i = 0;
        char[] c = s.toCharArray();
        while (i < 9) {
            cur = (cur << 2) | map.get(c[i]);
            i++;
        }
        Map<Integer, Integer> dna = new HashMap<>();
        while (i < c.length) {
            cur = ((cur << 2) & 0xfffff) | map.get(c[i]);
            if (dna.containsKey(cur) && dna.get(cur) == 1)
                ans.add(s.substring(i-9, i+1));
            dna.put(cur, dna.getOrDefault(cur, 0) + 1);
            i++;
        }
        return ans;
    }
}