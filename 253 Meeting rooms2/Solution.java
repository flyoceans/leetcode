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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        // 最小堆
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        int max = 0;
        for (Interval i : intervals) {
            while (minHeap.size() > 0 && minHeap.peek().end <= i.start) {
                minHeap.poll();
            }
            minHeap.add(i);
            max = Math.max(max, minHeap.size());
        }
        
        return max;
    }
}