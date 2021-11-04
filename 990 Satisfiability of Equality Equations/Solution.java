class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for (int i = 0; i < parents.length; i++) parents[i] = i;
        
        for (String eq: equations) {
            if (eq.charAt(1) == '=') {
                union(parents, eq.charAt(0), eq.charAt(3));
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (isConnected(parents, eq.charAt(0), eq.charAt(3))) return false;
            }
        }
        return true;
    }
    
    private void union(int[] parents, char a, char b) {
        int pa = find(parents, a - 'a');
        int pb = find(parents, b - 'a');
        if (pa != pb) parents[pa] = parents[pb];
    }
    
    private int find(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = find(parents, parents[a]);
        }
        return parents[a];
    }
    
    private boolean isConnected(int[] parents, char a, char b) {
        return find(parents, a - 'a') == find(parents, b - 'a');
    }
}