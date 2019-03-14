class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int largestComponentSize(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 2; j <= Math.sqrt(A[i]+0.0); j++) {
                if (A[i] % j == 0) {
                    union(A[i], A[i]/j);
                    union(A[i], j);
                }
            }
        }    

        int max = 1;
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            int key = find(a);
            count.put(key, count.getOrDefault(key, 0) + 1);
            max = Math.max(count.get(key), max);
        }
        return max;
    }
    
    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            map.put(pa, pb);
        }
    }
    
    private int find(int a) {
        map.putIfAbsent(a, a);
        if (map.get(a) != a) {
            map.put(a, find(map.get(a)));
        }
        return map.get(a);
    }
}