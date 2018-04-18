class Solution {
    // 同464 CanIWin
    // 使用byte[] 做memo会越界，改用hashmap
    // Arrays.toString(char[] c) 开销很大，不如 new String(char[] c)
    // time complexity O(2^n)
    private HashMap<String, Boolean> m;
    public boolean canWin(String s) {
        if (s == null || s.length() < 2)
            return false;
        // m = new byte[1 << len];
        m = new HashMap<>();
        char[] c = s.toCharArray();
        return canWin(c);
    }
    
    private boolean canWin(char[] state) {
        String str = new String(state);
        if (m.containsKey(str))
            return m.get(str);
        for (int i = 1; i < str.length(); i++) {
            if (state[i] != '+' || state[i-1] != '+')
                continue;
            state[i] = '-';
            state[i-1] = '-';
            boolean res = canWin(state);
            state[i] = '+';
            state[i-1] = '+';
            if (!res) {
                m.put(str, true);
                return true;
            }
        }
        m.put(str, false);
        return false;
    }
}