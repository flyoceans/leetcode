class Solution {
    /*
        getCnt 处理读数，getName 处理读名字
        遇到括号 recurse下一层
        坐标i 是全局共享变量
    */
    int i;
    public String countOfAtoms(String formula) {
        char[] f = formula.toCharArray();
        Map<String, Integer> map = helper(f);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1)
                sb.append(entry.getValue());
        }
        return sb.toString();
    }
    
    Map<String, Integer> helper(char[] f) {
        Map<String, Integer> map = new TreeMap<>();
        while (i < f.length) {
            if (f[i] == '(') {
                i++;
                Map<String, Integer> sub = helper(f);
                for (Map.Entry<String, Integer> entry : sub.entrySet()) {
                    String key = entry.getKey();
                    map.put(key, map.getOrDefault(key, 0) + entry.getValue());
                }
            } else if (f[i] == ')') {
                i++;
                int cnt = getCnt(f);

                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    map.put(entry.getKey(), cnt * entry.getValue());
                }
                return map;
            } else {
                String name = getName(f);
                int cnt = getCnt(f);

                map.put(name, map.getOrDefault(name, 0) + cnt);
            }
        }
        return map;
    }
    
    String getName(char[] f) {
        boolean pre = false;
        String name = "";
        while (i < f.length && (Character.isUpperCase(f[i]) && !pre || Character.isLowerCase(f[i]))) {
            name += f[i];
            i++;
            pre = true;
        }
        return name;
    }
    
    int getCnt(char[] f) {
        if (i == f.length) return 1;
        if (!Character.isDigit(f[i])) return 1;
        
        int cnt = 0;
        while (i < f.length && Character.isDigit(f[i])) {
            cnt = cnt*10 + (f[i] - '0');
            i++;
        }
        return cnt;
    }
}