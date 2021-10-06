class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) return -1;
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int steps = 1, res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) continue;
                    grid[x][y] = steps;
                    res = Math.max(res, steps);
                    queue.add(new int[]{x, y});
                }
            }
            steps++;
        }
        return res;
    }
}