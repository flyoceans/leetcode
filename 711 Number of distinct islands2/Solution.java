class Solution {
     private static final int dr[] = {1, -1, 0, 0};
    private static final int dc[] = {0, 0, 1, -1};
    private static final int INF = 10000;

    private int left = INF;
    private int right = 0;
    private int top = INF;
    private int bottom = 0;

    private void markIsland(int[][] grid, int row, int col, int id) {
        left = Math.min(left, col);
        right = Math.max(right, col);
        top = Math.min(top, row);
        bottom = Math.max(bottom, row);

        grid[row][col] = id;
        for (int i = 0; i < 4; ++i) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                markIsland(grid, nr, nc, id);
            }
        }
    }

    private int[][] cutIsland(int[][] grid, int r1, int c1, int r2, int c2, int id) {
        int[][] res = new int[r2 - r1 + 1][c2 - c1 + 1];
        for (int i = r1; i <= r2; ++i) {
            for (int j = c1; j <= c2; ++j) {
                if (grid[i][j] == id) {
                    res[i - r1][j - c1] = 1;
                }
            }
        }
        return res;
    }

    private int[][] rotate90(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] res = new int[col][row];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res[j][row - i - 1] = grid[i][j];
            }
        }
        return res;
    }

    private int[][] upDown(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] res = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res[row - i - 1][j] = grid[i][j];
            }
        }
        return res;
    }

    private int[][] leftRight(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] res = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res[i][col - j - 1] = grid[i][j];
            }
        }
        return res;
    }

    boolean same(int[][] g1, int[][] g2) {
        if (g1.length != g2.length || g1[0].length != g2[0].length) {
            return false;
        }

        for (int i = 0; i < g1.length; ++i) {
            for (int j = 0; j < g1[0].length; ++j) {
                if (g1[i][j] != g2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    List<int[][]> transform(int[][] orig) {
        List<int[][]> trans = new ArrayList<>();
        trans.add(orig);
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(upDown(orig));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(leftRight(orig));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        trans.add(rotate90(trans.get(trans.size() - 1)));
        return trans;
    }

    public int numDistinctIslands2(int[][] grid) {
        int id = 2;

        int row = grid.length;
        int col = grid[0].length;

        List<int[][]> islands = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    left = INF; right = 0; top = INF; bottom = 0;
                    markIsland(grid, i, j, id);
                    islands.add(cutIsland(grid, top, left, bottom, right, id));
                    ++id;
                }
            }
        }

        int sz = islands.size();
        boolean[] vis = new boolean[sz];

        int res = 0;
        for (int i = 0; i < sz; ++i) {
            if (vis[i] == false) {
                ++res;

                List<int[][]> trans = transform(islands.get(i));
                int num = trans.size();
                for (int j = i + 1; j < sz; ++j) {
                    for (int k = 0; k < num; ++k) {
                        if (same(islands.get(j), trans.get(k))) {
                            vis[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return res;
    }
}