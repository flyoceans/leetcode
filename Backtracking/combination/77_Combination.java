class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, n, k, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, int k, int visited, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = visited+1; i <= n; i++) {
            // if (visited[i])
            //     continue;
            path.add(i);
            helper(res, n, k, i, path);
            path.remove(path.size()-1);
        }
        return;
    }
}