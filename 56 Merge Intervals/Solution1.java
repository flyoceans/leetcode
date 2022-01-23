class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}