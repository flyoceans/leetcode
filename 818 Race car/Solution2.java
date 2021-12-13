class Solution {
    // 0-> 1 -> 3 -> 7
    // t = 2^n -1
    // Two ways to get the target
    // 1. accelerate, stop, restart
    // 2. accelerate, pass, reverse
    // m[t][d] min steps to reach position t and facing d (right = 0, left = 1)
    // m[t][d] = { n + 1 + min(m[2^n - 1 - t][1], m[2^n - 1 - t][0] + 1), pass and reverse
    //             m[i][0] + 2 + m[t - i][d], stop and restart
    //             m[i][1] + 1 + m[t - i][d] }
    // O(10000^2)
    private static int[][] m;
    public int racecar(int target) {
        if (m == null) {
        m = new int[10001][2];
        
        for (int t = 1; t < m.length; t++) {
            int n = (int) Math.ceil(Math.log(t + 1) / Math.log(2));
            if ((1 << n) == t + 1) {
                m[t][0] = n;
                m[t][1] = n + 1;
                continue;
            }
            
            m[t][0] = n + 1 + Math.min(m[(1<<n) - 1 - t][1], m[(1<<n) - 1 - t][0] + 1);
            m[t][1] = n + 1 + Math.min(m[(1<<n) - 1 - t][0], m[(1<<n) - 1 - t][1] + 1);
            
            for (int i = 1; i < t; i++) {
                for (int d = 0; d < 2; d++) {
                    m[t][d] = Math.min(m[t][d], Math.min(m[i][0] + 2 + m[t - i][d], m[i][1] + 1 + m[t-i][d]));
                }
            }
        }
        }
        return Math.min(m[target][0], m[target][1]);
    }
}