class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Map<Integer, List<Integer>> red = new HashMap<>();
        for (int[] edge : red_edges) {
            red.putIfAbsent(edge[0], new ArrayList<Integer>());
            red.get(edge[0]).add(edge[1]);
        }
        Map<Integer, List<Integer>> blue = new HashMap<>();
        for (int[] edge : blue_edges) {
            blue.putIfAbsent(edge[0], new ArrayList<Integer>());
            blue.get(edge[0]).add(edge[1]);
        }

        Set<Integer> visited_red = new HashSet<>();
        Set<Integer> visited_blue = new HashSet<>();
        visited_red.add(0);
        visited_blue.add(0);
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0));
        queue.add(new State(0, 1));
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();

                res[cur.node] = res[cur.node] == -1 ? steps : Math.min(steps, res[cur.node]);
                if (cur.color == 0) { // red
                    if (!blue.containsKey(cur.node)) continue;
                    for (int next : blue.get(cur.node)) {
                        if (visited_blue.contains(next)) continue;
                        visited_blue.add(next);
                        queue.add(new State(next, 1));
                    }
                } else {
                    if (!red.containsKey(cur.node)) continue;
                    for (int next : red.get(cur.node)) {
                        if (visited_red.contains(next)) continue;
                        visited_red.add(next);
                        queue.add(new State(next, 0));
                    }
                }
            }
            steps++;
        }
        
        return res;
    }
    
    class State {
        int node;
        int color;
        State(int n, int c) {
            this.node = n;
            this.color = c;
        }
    }
}