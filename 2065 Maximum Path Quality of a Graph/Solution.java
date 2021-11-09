class Solution {
    int max;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            g.putIfAbsent(edge[0], new HashMap<>());
            g.putIfAbsent(edge[1], new HashMap<>());
            g.get(edge[0]).put(edge[1], edge[2]);
            g.get(edge[1]).put(edge[0], edge[2]);
        }

        int[] visited = new int[values.length];
        dfs(0, 0, values, g, visited, maxTime);
        return max;
    }
    
    void dfs(int cur, int value, int[] values, Map<Integer, Map<Integer, Integer>> g, int[] visited, int time) {
        visited[cur]++;
        if (visited[cur] <= 1) value += values[cur];
        if (cur == 0) max = Math.max(value, max);

        if (g.containsKey(cur)) {
            for (Map.Entry<Integer, Integer> pair : g.get(cur).entrySet()) {
                int cost = pair.getValue();
                int next = pair.getKey();
                if (cost > time) continue;
                dfs(next, value, values, g, visited, time - cost);
            }
        }

        visited[cur]--;
        return;
    }
}