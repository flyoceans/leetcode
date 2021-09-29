class Solution {
    enum State {
        UNSAFE,
        SAFE,
        UNKNOWN;
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // i -> graph[i]
        State[] states = new State[graph.length];
        Arrays.fill(states, State.UNKNOWN);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, states, i) == State.SAFE) res.add(i);
        }
        Collections.sort(res);
        return res;
    }
    
    State dfs(int[][] graph, State[] states, int node) {
        if (states[node] != State.UNKNOWN) // visited 
            return states[node];
        if (states[node] == State.UNSAFE) // visiting
            return State.UNSAFE;
        
        states[node] = State.UNSAFE;
        for (int next : graph[node]) {
            if (dfs(graph, states, next) == State.UNSAFE) return State.UNSAFE;
        }
        states[node] = State.SAFE;
        return State.SAFE;
    }
}