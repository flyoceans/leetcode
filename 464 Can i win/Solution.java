class Solution {
    // memo可以用Hashmap，也可以用2^n的数组。
    // 此处用byte而不用boolean因为byte是两字节，boolean四字节
    private byte[] m;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 简单剪枝
        if (desiredTotal <= 0) return true;
        // int sum = 0;
        // for (int i = 1; i <= maxChoosableInteger; i++) sum += i;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        
        m = new byte[1 << maxChoosableInteger];
        return helper(maxChoosableInteger, desiredTotal, 0);
    }
    
    private boolean helper(int M, int T, int state) {
        if (T <= 0)
            return false;
        if (m[state] != 0) return m[state] == 1;
        for (int i = 0; i < M; i++) {
            if ((state & (1 << i)) != 0) continue;
            if (!helper(M, T-i-1, state | (1<<i))) {
                m[state] = 1;
                return true;
            }
        }
        m[state] = -1;
        return false;
    }
}