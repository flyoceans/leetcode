class Solution {
    public int partitionArray(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : nums) {
            treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }

        if (k == 0) return treeMap.size();

        int key = treeMap.ceilingKey(0);
        int res = 0;
        while (treeMap.ceilingKey(key) != null) {
            key = treeMap.ceilingKey(key) + k + 1;
            res++;
        }

        return res;
    }
}