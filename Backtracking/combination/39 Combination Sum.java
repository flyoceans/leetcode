class Solution {
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> res = new ArrayList<>();

    //     dfs(candidates, 0, 0, target, new ArrayList<>(), res);

    //     return res;
    // }

    // void dfs(int[] candidates, int pos, int curTarget, int target, List<Integer> sol, List<List<Integer>> res) {
    //     if (curTarget == target) {
    //         res.add(new ArrayList<>(sol));
    //         return;
    //     }

    //     if (curTarget > target || pos == candidates.length) {
    //         return;
    //     }

    //     sol.add(candidates[pos]);
    //     dfs(candidates, pos, curTarget + candidates[pos], target, sol, res);
    //     sol.remove(sol.size() - 1);

    //     dfs(candidates, pos + 1, curTarget, target, sol, res);
    // }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    
    void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int pos, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (i != pos && candidates[i-1] == candidates[i]) continue;
            if (target >= candidates[i]) {
                cur.add(candidates[i]);
                dfs(res, cur, candidates, i, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}