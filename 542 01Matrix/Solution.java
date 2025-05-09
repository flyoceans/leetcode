class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] idx = queue.poll();
                int x = idx[0];
                int y = idx[1];
                for (int[] dir : dirs) {
                    int dx = dir[0] + x;
                    int dy = dir[1] + y;
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n || visited[dx][dy]) continue;
                    res[dx][dy] = res[x][y] + 1;
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
        return res;
    }
}