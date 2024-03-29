// Count # of primes that < n

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n+1];
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                cnt++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return cnt;
    }
}