class Solution {    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) 
            return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    num++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void dfs(int[][] visited, char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (visited[i][j] == 1 || grid[i][j] == '0')
            return;
        visited[i][j] = 1;
        dfs(visited, grid, i+1, j);
        dfs(visited, grid, i, j+1);
        dfs(visited, grid, i-1, j);
        dfs(visited, grid, i, j-1);
        return;
    }
}