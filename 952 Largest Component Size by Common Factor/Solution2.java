class Solution {
    // UnionFind
    // Set max rank
    class UnionFind {
        int[] parents;
        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
            
        }
        
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parents[pa] = parents[pb];
        }
        
        int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }
            return parents[a];
        }
    }
    
    public int largestComponentSize(int[] nums) {
        UnionFind uf = new UnionFind(100_001);
        for (int a : nums) {
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    uf.union(a, i);
                    uf.union(a, a / i);
                }
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int a : nums) {
            int tmp = uf.find(a);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            max = Math.max(max, map.get(tmp));
        }
        return max;
    }
}