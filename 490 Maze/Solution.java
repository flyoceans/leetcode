class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        // if (maze == null || maze.length == 0)
        //     return false;
        if (start[0] == dest[0] && start[1] == dest[1])
            return true;
        int[][] visited = new int[maze.length][maze[0].length];
        return dfs(maze, start, dest, visited);
    }
    
    private boolean dfs(int[][] maze, int[] curr, int[] dest, int[][] visited) {
        if (visited[curr[0]][curr[1]] != 0)
            return false;   //visited
        if (Arrays.equals(curr, dest))
            return true;
        
        visited[curr[0]][curr[1]] = 1;
        int[][] ds = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : ds) {
            int x = curr[0] + d[0];
            int y = curr[1] + d[1];
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] != 1) {
                x += d[0];
                y += d[1];
            }
            if (dfs(maze, new int[]{x - d[0], y - d[1]}, dest, visited)) return true;
        }
        return false;
    }
}