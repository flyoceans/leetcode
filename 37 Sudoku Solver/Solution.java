class Solution {
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    rows[i][board[i][j] - '1'] = 1;
                    cols[j][board[i][j] - '1'] = 1;
                    sqs[(i/3) * 3 + j/3][board[i][j] - '1'] = 1;
                }
            }
        }
        
        dfs(board, 0, 0);
    }
    
    boolean dfs(char[][] board, int x, int y) {
        if (y == 9) return true;
        int nx = (x + 1) % 9;
        int ny = (nx == 0 ? y + 1 : y);
        
        if (board[x][y] != '.') return dfs(board, nx, ny);
        
        for (char c = '1'; c <= '9'; c++) {
            if (rows[x][c - '1'] == 1 || cols[y][c - '1'] == 1 || sqs[(x/3) * 3 + y/3][c - '1'] == 1) continue;
            board[x][y] = c;
            rows[x][c - '1'] = 1;
            cols[y][c - '1'] = 1;
            sqs[(x/3) * 3 + y/3][c - '1'] = 1;
            if (dfs(board, nx, ny)) return true;
            board[x][y] = '.';
            rows[x][c - '1'] = 0;
            cols[y][c - '1'] = 0;
            sqs[(x/3) * 3 + y/3][c - '1'] = 0;
        }
        
        return false;
    }
    
    int[][] rows = new int[9][9];
    int[][] cols = new int[9][9];
    int[][] sqs = new int[9][9];
    
}