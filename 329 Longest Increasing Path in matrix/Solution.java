class Solution {
     //DAG Longest path, no fix source. O(n^2)
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int max = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, cache, i, j));
            }
        }
        return max;
    }
    
    
    private int dfs(int[][] matrix, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) 
            return cache[x][y];
        int r = matrix.length;
        int c = matrix[0].length;
        if (x < 0 || y < 0 || x >= r || y >= c) {
            return 0;
        }
                
        int[][] diff = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int dx = x + diff[i][0];
            int dy = y + diff[i][1];
            if (dx < 0 || dy < 0 || dx >= r || dy >= c) {
                continue;
            }
            
            if (matrix[dx][dy] > matrix[x][y]) {
                
                max = Math.max(max, dfs(matrix, cache, dx, dy)+1);
            }
            
        }
        cache[x][y] = max;
        return max;
    }
}