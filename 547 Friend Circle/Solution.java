class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(M, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (visited[j] == 0 && M[i][j] == 1) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}