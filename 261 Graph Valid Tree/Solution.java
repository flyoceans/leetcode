class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        if (edges.length != n-1)
            return false;
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1]))
                return false;
            uf.union(edge[0], edge[1]);
        }
        return true;
    }
    
    
    class UF {
        int[] parents;
        public UF(int size) {
            parents = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }
        
        public void union(int a, int b) {
            int p_a = find(a);
            int p_b = find(b);
            if (!connected(p_a, p_b)) {
                parents[p_a] = p_b;
            }
        }
        
        public int find(int a) {
            int n = a;
            while (parents[n] != n) {
                n = parents[n];
            }
            return n;
        }
        
        public boolean connected(int a, int b) {
            if (a == b)
                return true;
            int p_a = find(a);
            int p_b = find(b);
            return p_a == p_b;
        }
    }
}