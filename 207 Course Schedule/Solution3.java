class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // (0, 1), 1->0
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            if (!graph.containsKey(node)) continue;
            for (int next : graph.get(node)) {
                indegrees[next]--;
                if (indegrees[next] == 0) queue.add(next);
            }
            // graph.remove(node);      
        }
        return cnt == numCourses;
    }
}