class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0], r = matrix[n-1][n-1];
        while (l + 1 < r) {
            int mid = (l + r) /2;
            int cnt = countLessOrEqual(matrix, mid); // O(M + N);
            
            if (cnt < k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (countLessOrEqual(matrix, l) < k) return r;
        return l;
    }
    
    int countLessOrEqual(int[][] matrix, int x) {
        int cnt = 0, c = matrix.length - 1; // start with the rightmost column
        for (int r = 0; r < matrix.length; r++) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
}