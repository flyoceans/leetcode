class Solution {
    public int numberOfPatterns(int m, int n) {
        // dict
        int[][] dict = new int[10][10];
        dict[1][3] = dict[3][1] =  2;
        dict[1][7] = dict[7][1] = 4;
        dict[3][9] = dict[9][3] = 6;
        dict[7][9] = dict[9][7] = 8;
        dict[1][9] = dict[9][1] = dict[3][7] = dict[7][3] = 5;
        dict[2][8] = dict[8][2] = dict[4][6] = dict[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += dfs(dict, visited, i, 1) * 4;
            res += dfs(dict, visited, i, 2) * 4;
            res += dfs(dict, visited, i, 5);
        }
        return res;
    }
    
    private int dfs(int[][] dict, boolean[] visited, int step, int prev) {
        if (step == 1) 
            return 1;
        
        int res = 0;
        visited[prev] = true;
        
        for (int i = 1; i < 10; i++) {
            int skip = dict[prev][i];
            if (!visited[i] && (skip == 0 || visited[skip])) {
                res += dfs(dict, visited, step-1, i);
            }
        }
        
        visited[prev] = false;
        // System.out.println(res);
        return res;
    }
}