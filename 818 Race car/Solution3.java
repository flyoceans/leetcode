class Solution {
    // target = 2^n - 1
    
    int[] memo = new int[10001];
    public int racecar(int target) {
        if (memo[target] != 0) {
            return memo[target];
        }
        
        int n = (int) Math.ceil(Math.log(target + 1) / Math.log(2));
        if ((1<<n) == target + 1) {
            memo[target] = n;
        } else {
            memo[target] = racecar((1<<n) - 1 - target) + n + 1; // pass target and reverse
            for (int m = 0; m < n - 1; m++) {
                memo[target] = Math.min(memo[target], racecar(target - (1<<(n - 1)) + (1<<m)) + n - 1 + 2 + m); //Go (n-1) A then R and m A then R
            }
        }
        
        return memo[target];
    }
}