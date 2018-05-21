class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int[][] visited, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        if (i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1)
            return false;
        if (visited[i][j] == 1 || word.charAt(index) != board[i][j])
            return false;
        visited[i][j] = 1;
        boolean res = search(board, visited, word, index+1, i+1, j) ||
        search(board, visited, word, index+1, i, j+1) ||
        search(board, visited, word, index+1, i-1, j) ||
        search(board, visited, word, index+1, i, j-1);
        visited[i][j] = 0;
        return res;
    }
}