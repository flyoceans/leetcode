class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        Set<String> set = new HashSet<>();
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (end.equals(cur)) return steps;
                for (String next : bank) {
                    if (!set.contains(next) && valid(cur, next)) {
                        set.add(next);
                        queue.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    boolean valid(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }
}