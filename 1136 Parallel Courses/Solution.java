class Solution {
    // BFS + topo sort
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.putIfAbsent(prev, new ArrayList<>());
            graph.get(prev).add(next);
            indegree[next]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) queue.add(i);
        int steps = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                visited.add(cur);
                if (!graph.containsKey(cur)) continue;
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) queue.add(next);
                }
            }
            steps++;
        }
        return visited.size() == n ? steps : -1;
    }
}