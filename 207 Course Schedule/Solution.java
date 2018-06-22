class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] status = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, status)) return false;
        }
        return true;
    }
    
    private boolean dfs(List<List<Integer>> graph, int node, int[] status) {
        if (status[node] == 1) //visited
            return true;
        if (status[node] == 2) //visiting, 因为graph里拓扑排序不能有环
            return false;
        
        status[node] = 2;
        List<Integer> neighbors = graph.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            if (!dfs(graph, neighbors.get(i), status))
                return false;
        }
        status[node] = 1;
        
        return true;
    }
}