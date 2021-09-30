class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();  // Key:stop, Value:list of bus travels this stop
        
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                map.putIfAbsent(j, new ArrayList<Integer>());
                map.get(j).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>(); // Store bus

        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == target) return steps;
                for (int bus : map.get(cur)) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int next : routes[bus]) {
                        if (next != cur) queue.add(next);
                    }
                }
            }
            steps++;
            
        }
        
        return -1;
    }

}