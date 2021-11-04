class Solution {
    enum Color {
        UNKNOWN,
        RED,
        BLUE,
    }
    public boolean isBipartite(int[][] graph) {
        Color[] color = new Color[graph.length];
        Arrays.fill(color, Color.UNKNOWN);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == Color.UNKNOWN && !dfs(graph, color, i, Color.RED)) return false;
        }
        return true;
    }
    
    boolean dfs(int[][] graph, Color[] color, int cur, Color turn) {
        if (color[cur] != Color.UNKNOWN) return color[cur] == turn;
        color[cur] = turn;
        
        for (int next : graph[cur]) {
            if (!dfs(graph, color, next, turn == Color.RED ? Color.BLUE : Color.RED)) return false;
        }
        return true;
    }
}