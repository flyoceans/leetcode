class Solution {
    // Map<root, PQ> 
    
    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parent = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        // for (int i = 0; i < s.length(); i++)
        // System.out.println(parent[i]);
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue<Character>());
            map.get(root).offer(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    
    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa < pb) parent[pa] = pb;
        else parent[pb] = pa;
    }
    
    int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}