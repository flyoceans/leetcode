class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        int[] visited = new int[n];
        return dfs(source, destination, graph, visited);

    }

    // 0 undefined, 1 visiting, 2 visited
    boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph, int[] visited) {

        if (visited[source] == 1)
            return false;
        if (visited[source] == 2)
            return true;
        
        
        visited[source] = 1;
        if (graph.containsKey(source)) {
            for (int next : graph.get(source)) {
                if (!dfs(next, destination, graph, visited))
                    return false;
            }
        } else {
            if (source != destination) return false;
        }
        visited[source] = 2;
        return true;
    }
}