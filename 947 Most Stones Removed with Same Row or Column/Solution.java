class Solution {
    
    Map<Integer, Integer> f = new HashMap<>();
    int island = 0;
    
    public int removeStones(int[][] stones) {
        island = stones.length;
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0]));
        }
        return stones.length - set.size();
    }

    public int find(int x) {
        f.putIfAbsent(x, x);
        if (f.get(x) != x)
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
        }
    }
}