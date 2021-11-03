class Solution {
    // union find
    // O(n^2 * length)
    
    class UnionFind {
        int[] parents;
        int cnt;
        
        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;
            cnt = n;
        }
        
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            else if (pa > pb) parents[pa] = parents[pb];
            else parents[pb] = parents[pa];
            cnt--;
        }
        
        int find(int a) {
            if (parents[a] != a) {
                parents[a] = find(parents[a]);
            }
            return parents[a];
        }
    }
    
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if (similar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.cnt;
    }
    
    private boolean similar(String a, String b) {
        int cnt = 2;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt--;
                if (cnt < 0) return false;
            }
        }
        return true;
    }
}