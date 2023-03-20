class Solution {
    //bfs
    // Graph, 无向无环图，模版bfs
    // O(8 * 10^4)
    // 注意轮播0-9的小tricky
    public static int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        int depth = 0;
        q.add("0000");
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String node = q.poll();
                if(node.equals(target)) return depth;
                if(visited.contains(node)) continue;
                visited.add(node);
                q.addAll(getSuccessors(node));
            }
            depth++;
        }
        return -1;
    }
    
    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        // charArray[i] = (char)(c - '0' - 1); buxing

        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return res;
    }
    
    
}