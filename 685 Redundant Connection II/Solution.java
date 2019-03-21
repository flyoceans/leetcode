class Solution {
    /*
    题目想最后得到tree structure，分为三种情况：
        1. duplicate parents, but no cycle, 这时应该删除2->3
          1
         / \
        v   v
        2-->3
        
        2. no duplicate parents, but cycle，删除4->1
        5 <- 1 -> 2
             ^    |
             |    v
             4 <- 3
        3. duplicate parents & cycle, 删除2->1
        2 -> 1 <- 3
        ^   /
         \ v
          4
    所以总结一下，duplicate parents必删其中之一，cycle 也必删其中之一。如果没有dup，那么就是redundant connection1。如果有dup，记录他们两作为         candidates，然后再在cycle里找。
    */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length+1];
        int[] can1 = new int[2];
        int[] can2 = new int[2];
        
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            if (parents[v] != 0) { // duplicate parents
                can1[0] = parents[v];
                can1[1] = v;
                can2[0] = u;
                can2[1] = v;
                edges[i][0] = -1;
                edges[i][1] = -1;
            }
            parents[v] = u;
        }
        
        UF uf = new UF(edges.length);
        // System.out.println(Arrays.toString(can1));
        // System.out.println(Arrays.toString(can2));
        //   System.out.println(can1.length);
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == -1) continue;
            if (!uf.union(edges[i][0], edges[i][1])) {
                if (can1[0] == 0) // 情况2
                    return edges[i];
                else // 情况3
                    return can1;
            }
        }
        
        return can2;
    }
    
    
    class UF {
        private int[] parents;
        
        public UF(int n) {
            parents = new int[n+1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        } 
        
        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parents[pb] = pa;
                return true;
            } 
            return false;
        }
        
        public int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }
            return parents[a];
        }
        
    }
}