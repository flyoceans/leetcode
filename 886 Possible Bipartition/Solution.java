class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
         //建图, 相邻node颜色不能一样。
        List<Integer>[] graph = new ArrayList[N];
   
         for (int i = 0; i < N; ++i)
            graph[i] = new ArrayList<>();
        for (int[] edge : dislikes) {
            graph[edge[0]-1].add(edge[1]-1);
            graph[edge[1]-1].add(edge[0]-1);
        }
        
        int[] colors = new int[N]; // 0, +1 red, -1 black;
        for (int i = 0; i < N; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) return false;
        }
        return true;
    }
    
    private boolean dfs(ArrayList<Integer>[] graph, int[] colors, int v, int color) {
        colors[v] = color;
        for (int i = 0; i < graph[v].size(); i++) {
            int next = graph[v].get(i);
            if (colors[next] == color) return false; // 相邻同色，fail
            if (colors[next] == 0 && !dfs(graph, colors, next, -color)) return false;
        }
        return true;
    }
}