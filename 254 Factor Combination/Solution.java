class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<Integer>(), n, 2);
        return list;
    }
    
    private void helper(List<List<Integer>> list, List<Integer> path, int n, int start) {
        if (n == 1) {
            if (path.size() < 2) return;
            list.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                helper(list, path, n/i, i);
                path.remove(path.size()-1);
            }
        }
    
        return;    
    }
}