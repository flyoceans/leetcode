class Solution {
    // Dijkstra
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap();
        for (int[] edge: times) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Pair(edge[1], edge[2]));
        }
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
                (info1, info2) -> info1.getValue() - info2.getValue());
        heap.offer(new Pair(K, 0));

        // from source to every node 
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        minDist[K] = 0;

        while (!heap.isEmpty()) {
            Pair<Integer, Integer> curr = heap.poll();
            int time = curr.getValue(), node = curr.getKey();
            
            if (time > minDist[node]) continue;
            if (!graph.containsKey(node)) continue;

            for (Pair<Integer, Integer> edge: graph.get(node)) {
                int nextTime = edge.getValue(), nextNode = edge.getKey();

                if (minDist[nextNode] > nextTime + minDist[node]) {
                    // release the edge, update the distance
                    minDist[nextNode] = nextTime + minDist[node];
                    heap.offer(new Pair(nextNode, minDist[nextNode]));
                }
            }
            
        }

        int res = 0;
        for (int time : minDist) {
            if (time == Integer.MAX_VALUE) return -1;
            res = Math.max(res, time);
        }
        return res;
    }
}