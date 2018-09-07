class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {    // 不一定是全连通图
            if (graph[i].length != 0 && visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int n : graph[curr]) {
                        if (visited[n] == 0) {
                            visited[n] = visited[curr] == 2 ? 1 : 2;
                            queue.add(n);
                        } else {
                            if (visited[n] == visited[curr])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}