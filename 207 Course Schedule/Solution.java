class Solution {
    
    enum State {
        VISITED,
        VISITING,
        UNKNOWN;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        
        State[] states = new State[numCourses];
        Arrays.fill(states, State.UNKNOWN);
        for (int i = 0; i < numCourses; i++) {
            if (dfs(states, i, graph) == State.VISITING) return false;
        }
        return true;
    }
    
    State dfs(State[] states, int node, Map<Integer, List<Integer>> graph) {
        if (states[node] != State.UNKNOWN) return states[node];
        
        states[node] = State.VISITING;
        if (graph.containsKey(node)) {
            for (int next : graph.get(node)) {
                if (dfs(states, next, graph) == State.VISITING) return State.VISITING;
            }
        }

        states[node] = State.VISITED;
        return State.VISITED;
    }

    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     List<List<Integer>> graph = new ArrayList<>();
    //     int[] status = new int[numCourses];
    //     for (int i = 0; i < numCourses; i++) {
    //         graph.add(new ArrayList<Integer>());
    //     }
    //     for (int[] pre : prerequisites) {
    //         graph.get(pre[1]).add(pre[0]);
    //     }
        
    //     for (int i = 0; i < numCourses; i++) {
    //         if (!dfs(graph, i, status)) return false;
    //     }
    //     return true;
    // }
    
    // private boolean dfs(List<List<Integer>> graph, int node, int[] status) {
    //     if (status[node] == 1) //visited
    //         return true;
    //     if (status[node] == 2) //visiting, 因为graph里拓扑排序不能有环
    //         return false;
        
    //     status[node] = 2;
    //     List<Integer> neighbors = graph.get(node);
    //     for (int i = 0; i < neighbors.size(); i++) {
    //         if (!dfs(graph, neighbors.get(i), status))
    //             return false;
    //     }
    //     status[node] = 1;
        
    //     return true;
    // }
}