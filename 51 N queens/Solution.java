class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        cols = new HashSet<>();
        dia1 = new HashSet<>();
        dia2 = new HashSet<>();
        
        dfs(res, new ArrayList<>(), 0, n);
        return res;
    }
    
    void dfs(List<List<String>> res, List<String> way, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(way));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || dia1.contains(row - i) || dia2.contains(row + i)) continue;
            // System.out.println(cols);
            // System.out.println(dia1);
            // System.out.println(dia2);
            cols.add(i);
            dia1.add(row - i);
            dia2.add(row + i);
            way.add(getStringRow(i, n));
            dfs(res, way, row + 1, n);
            way.remove(way.size()-1);
            cols.remove(i);
            dia1.remove(row - i);
            dia2.remove(row + i);
        }
    }
    
    String getStringRow(int x, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != x)
                sb.append(".");
            else 
                sb.append("Q");
        }
        return sb.toString();
    }
    
    Set<Integer> cols;
    Set<Integer> dia1;
    Set<Integer> dia2;
}