/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0)
            return ans;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        Interval prev = intervals.get(0);
        int start = prev.start;
        int end = prev.end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                Interval tmp = new Interval(start, end);
                ans.add(tmp);
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}