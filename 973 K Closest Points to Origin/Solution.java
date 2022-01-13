class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // Max Heap O(n * logk)
        int[][] res = new int[k][2];
        
        // PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1];
        //     }
        // });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]));
        
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}