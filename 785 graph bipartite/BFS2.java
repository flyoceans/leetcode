class Solution {
    // BFS
    // Neighbor layer must be different color
    // Start from node 0
    
    enum State {
        RED,
        BLUE,
        UNKNOWN;
    }
    
    public boolean isBipartite(int[][] graph) {
        State[] g = new State[graph.length];
        Arrays.fill(g, State.UNKNOWN);     
        
        Queue<Integer> queue = new LinkedList<>();
        for (int k = 0; k < graph.length; k++) {
            if (g[k] == State.UNKNOWN) {
                queue.add(k);
                State turn = State.RED;
        
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        int node = queue.poll();
                        if (g[node] == State.UNKNOWN) {
                            g[node] = turn;
                            for (int next : graph[node]) {
                                queue.add(next);
                            }
                        } else if (g[node] != turn) {
                            return false;
                        }
                    }
                    turn = (turn == State.RED) ? State.BLUE : State.RED;
                }
            }
        }
        return true;
    }
}