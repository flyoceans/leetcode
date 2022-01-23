class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
        
        int res = 1;
        int[] cur = points[0];
        for (int i = 1; i < points.length; i++) {
            if (cur[1] < points[i][0]) {
                cur = points[i];
                res++;
            }
        }
        return res;
    }
}