class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] path : paths) {
            graph.get(path[0]-1).add(path[1]-1);
            graph.get(path[1]-1).add(path[0]-1);
        }
        
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int next : graph.get(i)) {
                mask |= (1 << res[next]);
            }
            for (int c = 1; c <= 4 && res[i] == 0; c++)
                if ((mask & (1 << c)) == 0) res[i] = c;
        }
        return res;
    }
}