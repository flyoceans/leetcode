class Solution {
    class UF {
        int[] parents;
        int[] ranks;
        int M;
        int N;
        int count;
        
        public UF(int m, int n) {
            M = m;
            N = n;
            count = 0;
            parents = new int[m*n];
            ranks = new int[m*n];
            for (int i = 0; i < parents.length; i++)
                parents[i] = -1;
        }
        
        public int find(int x) {
            if (x < 0 || x >= M*N)
                return -1;
            if (parents[x] != x) parents[x] = find(parents[x]);
            return parents[x];
        }
        
        public void union(int a, int b) {
            int p_a = find(a);
            int p_b = find(b);
            if (p_a != p_b) {
                if (ranks[p_a] > ranks[p_b]) {
                    parents[p_b] = p_a;
                    ranks[p_a] += ranks[p_b];
                } else {
                    parents[p_a] = p_b;
                    ranks[p_b] += ranks[p_a];
                }
                count--;
            }
        }
        
//         public boolean connected(int a, int b) {
//             int p_a = find(a);
//             int p_b = find(b);
//             return p_a == p_b;
//         }
        
        public void build(int i, int j) {
            int x = i*N + j;
            if (parents[x] != -1) return;
            parents[x] = x;
            ranks[x] += 1;
            if (i+1 < M && find(x + N) != -1) {
                union(x, x + N);
            }
            if (i-1 >= 0 && find(x - N) != -1) {
                union(x, x - N);
            }
            if (j+1 < N && find(x + 1) != -1) {
                union(x, x + 1);
            }
            if (j-1 >= 0 && find(x - 1) != -1) {
                union(x, x - 1);
            }
            count++;
        }
        
        public int count() {
            return count;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UF uf = new UF(m, n);
        for (int i = 0; i < positions.length; i++) {
            uf.build(positions[i][0], positions[i][1]);
            res.add(uf.count());
        }
        return res;
    }
}