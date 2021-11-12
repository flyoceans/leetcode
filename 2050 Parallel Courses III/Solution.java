class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
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
        int[] dist = new int[n]; // dist[i] time needed to finish task i, all prevCourse finish time + ith course time.
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0) {
                queue.add(i);
                dist[i] = time[i];
            }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (!graph.containsKey(cur)) continue;
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    dist[next] = Math.max(dist[next], dist[cur]);
                    if (indegree[next] == 0) {
                        queue.add(next);
                        dist[next] += time[next];
                    }
                }
            }
        }
        int max = 0;
        for (int i : dist) max = Math.max(max, i);
        return max;
    }
}