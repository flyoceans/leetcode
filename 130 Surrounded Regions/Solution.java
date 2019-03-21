class Solution {
    
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        
        // scan from border of the board.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '$') board[i][j] = 'O';
            }
        }
        
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'O') board[x][y] = '$';
        
        int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < 4; i++) {
            int dx = d[i][0] + x;
            int dy = d[i][1] + y;
            if ((dx >= 0 && dy >= 0 && dx < board.length && dy < board[0].length) && board[dx][dy] == 'O') {
                dfs(board, dx, dy);
            }
        }
    }
}