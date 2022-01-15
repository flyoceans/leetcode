class Solution {
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        
        int l = 0, r = prefixSums.length-1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (target < prefixSums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (target < prefixSums[l]) return l;
        return r;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */