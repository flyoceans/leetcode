class Solution {
    public int[][] insert(int[][]intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        List<int[]> r = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean flag = true;
        for (int[] interval : intervals) {
            if (interval[1] < start) {
                l.add(interval);
            } else if (interval[0] > end) {
                r.add(interval);
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        List<int[]> res = new ArrayList<>();
        res.addAll(l);
        res.add(new int[]{start, end});
        res.addAll(r);
            
        return res.toArray(new int[res.size()][2]);
    }
}