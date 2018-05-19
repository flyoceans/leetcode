class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) 
            return null;
        int m = A.length;
        int n = A[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            //res[i] = Collections.reverse(Arrays.asList(strings));
            for (int j = 0; j < n; j++) {
                res[i][j] = A[i][n-j-1];
                if (res[i][j] == 1)
                    res[i][j] = 0;
                else 
                    res[i][j] = 1;
            }
        }
        return res;
    }
}