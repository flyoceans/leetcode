class Solution {
    //bfs
    // Graph, 无向无环图，模版bfs
    // O(8 * 10^4)
    // 注意轮播0-9的小tricky
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target.equals(start)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains(start)) return -1;
        visited.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                List<String> neigbors = getNeigbors(tmp);
                for (String neigbor: neigbors) {
                    // System.out.println(neigbor);
                    if (neigbor.equals(target)) return steps;
                    if (!visited.contains(neigbor)) {
                        visited.add(neigbor);
                        queue.add(neigbor);
                    }
                    
                }
            }
        }
        return -1;
    }
    
    List<String> getNeigbors(String node) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int d = -1; d <= 1; d += 2) {
                char x = (char)(((node.charAt(i) - '0') + d + 10) % 10  + '0');
                String nei = node.substring(0, i) + x + node.substring(i+1);
                res.add(nei);
            }
        }
        return res;
    }
    
    
}