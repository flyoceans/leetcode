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
    public boolean canAttendMeetings(Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start < list.get(i-1).end)
                return false;
        }
        return true;
    }
}