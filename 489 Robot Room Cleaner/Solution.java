/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    
    private final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> visited, int curDir, int curRow, int curCol) {
        String s = curRow + "," + curCol;
        if (visited.contains(s)) return;
        visited.add(s);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int x = (curDir + i)%4;
            int row = curRow + dir[x][0];
            int col = curCol + dir[x][1];
            if (robot.move()) {
                dfs(robot, visited, x, row, col);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnLeft();
        }
    }
}