class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    res += count(grid, i, j);
            }
        }
        return res;
    }
    
    private int count(int[][] grid, int i, int j) {
        int res = 0;
        int row = i-1, col = j;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == 0)
                res++;
        } else {
            res++;
        }
        row = i;
        col = j-1;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == 0)
                res++;
        } else {
            res++;
        }
        row = i+1;
        col = j;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == 0)
                res++;
        } else {
            res++;
        }
        row = i;
        col = j+1;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if (grid[row][col] == 0)
                res++;
        } else {
            res++;
        }
        return res;
    }

}