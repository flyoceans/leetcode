class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int l = 1, r = 200_000;
        
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (valid(mid, n, q)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (valid(l, n, q)) return l;
        if (valid(r, n, q)) return r;
        return -1;
    }
    
    boolean valid(int x, int n, int[] q) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] % x == 0) n -= q[i] / x;
            else n -= (q[i] / x + 1);
            if (n < 0) return false;
        }
        return true;
    }
}