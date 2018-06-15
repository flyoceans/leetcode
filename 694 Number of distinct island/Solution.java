class Solution {
    private int m;
    private int n;
    Set<List<List<Integer>>> res;
    
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        res = new HashSet<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    List<List<Integer>> path = new ArrayList<>();
                    explore(i, j, i, j, grid, path);
                    res.add(path);
                }
            }
        }
        return res.size();
    }
    
    private void explore(int r0, int c0, int r, int c, int[][] grid, List<List<Integer>> path) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0)
            return;
        grid[r][c] *= -1;
        path.add(Arrays.asList(r - r0, c - c0));
        explore(r0, c0, r-1, c, grid, path);
        explore(r0, c0, r+1, c, grid, path);
        explore(r0, c0, r, c-1, grid, path);
        explore(r0, c0, r, c+1, grid, path);
        return;
    }
    
}