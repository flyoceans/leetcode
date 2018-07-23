class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String s = hashfunction(strings[i]);
            if (map.containsKey(s)) {
                map.get(s).add(strings[i]);
            } else {
                // map.put(s, Arrays.asList(strings[i]));
                //Exception in thread "main" java.lang.UnsupportedOperationException
                // Arrays.asList转化过来的ArrayList 不支持 add()和 remove()
                List<String> l = new ArrayList<>();
                l.add(strings[i]);
                map.put(s, l);
            }
        }
        // for (String s : map.keySet()) 
        //     System.out.println(s);
        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }
    
    
    private String hashfunction(String str) {
        // int[] c = new int[str.length()];
        // System.out.println(str);
        StringBuilder sb = new StringBuilder();
        int off = str.charAt(0) - 'a';
        sb.append('a');
        for (int i = 1; i < str.length(); i++) {
            sb.append((char)('a' + (str.charAt(i) - 'a' - off + 26)%26));
        }
         // System.out.println(sb.toString());
        return sb.toString();
    }
}