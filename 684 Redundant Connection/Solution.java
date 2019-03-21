class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) 
                return edge;
        }
        return new int[2];
    }
    
    class UF {
        
        private int[] parents;
        private int[] ranks;
        
        public UF(int size) {
            parents = new int[size+1];
            ranks = new int[size+1];
            for (int i = 0; i <= size; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return false;
            if (ranks[pu] > ranks[pv]) {
                parents[pv] = pu;
                ranks[pu] += ranks[pv];
            } else {
                parents[pu] = pv;
                ranks[pv] += ranks[pu];
            }
            return true;
        }
        
        public int find(int u) {
            while (parents[u] != u) {
                parents[u] = parents[parents[u]]; // pc
                u = parents[u];
            }
            return u;
        }
    }
}