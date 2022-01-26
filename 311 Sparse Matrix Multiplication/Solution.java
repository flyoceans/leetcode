public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, K = A[0].length, n = B[0].length;
        int[][] C = new int[m][n];

        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         for (int x = 0; x < k; x++)
        //             C[i][j] += A[i][x] * B[x][j];
        //     }
        // }
        
        // Sparse matrix avoid 0 manipulation
        // for (int i = 0; i < m; ++i) {
        //     for (int k = 0; k < K; ++k) {
        //         if (A[i][k] != 0) {
        //             for (int j = 0; j < n; ++j) {
        //                 if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
        //             }
        //         }
        //     }
        // }
        // return C;   
        
    Map<Integer, Set<Integer>> map1 = new HashMap<>(); // row to col for mat1
    Map<Integer, Set<Integer>> map2 = new HashMap<>(); // col to row for mat2 
    
        // build sparse map for A
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < K; c++) {
                if (A[r][c] != 0) {
                    map1.putIfAbsent(r, new HashSet<>());
                    map1.get(r).add(c);
                }
            }
        }
        
        // build sparse map for B
        for(int c = 0; c < n; c++) {
            for(int r = 0; r < K; r++) {
                if (B[r][c] != 0) {
                    map2.putIfAbsent(c, new HashSet<>());
                    map2.get(c).add(r);
                }
            }
        }
            
        int[][] res = new int[m][n]; // res = mat1.r * mat2.c
        
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                // use r for mat1 and c for mat2
                if (map1.containsKey(r) && map2.containsKey(c)) {
                    int total = 0;
                    // multiply values in row r in mat1 and col c in mat2
                    for(int index : map1.get(r)) {
                        if (map2.get(c).contains(index)) {
                            total += A[r][index] * B[index][c];
                        }
                    }
                    
                    res[r][c] = total;
                }
            }
        }
        
        return res;
    }
}