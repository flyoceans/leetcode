class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.cnt;
    }
    
    
    class UF {
        // Map<Integer, Integer> parent = new HashMap<>();
        int[] parents;
        int cnt;
        
        UF(int n) {
            cnt = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
        }
        
        public int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }
            return parents[a];
        }
        
        public void union(int a, int b) {
            int p_a = find(a);
            int p_b = find(b);
            if (p_a != p_b) {
                parents[p_a] = p_b;
                cnt--;
            }
        }
    }
}