class Solution {
    /**
     * sweeping line
     *
     */
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return ans;
        
        List<Event> list = new ArrayList<>();
        
        for (int[] building : buildings) {
            Event l = new Event(building[0], building[2], 0); //enter
            Event r = new Event(building[1], building[2], 1); //leave
            list.add(l);
            list.add(r);
        }
        
        Collections.sort(list, new Comparator<Event>(){
            public int compare(Event a, Event b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                } else {    //比较 h 和 type
                    if (a.type != b.type) { //如果type不同，enter的排前面
                        return a.type == 0 ? -1 : 1;
                    } else if (a.type == 0) {   //如果type都是enter，h高的先进
                        return b.h - a.h;
                    } else {    //如果type都是leave，h低的先进
                        return a.h - b.h;
                    }
                }
            }
        });
        // for (Event e : list)
        //     System.out.println(e.x + " " + e.h);
        Queue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b.intValue() - a .intValue();
            }
        });
        
        for (int i = 0; i < list.size(); i++) {
            Event e = list.get(i);
            if (e.type == 0) {  // enter
                if (maxHeap.size() == 0 || e.h > maxHeap.peek()) {
                    ans.add(new int[]{e.x, e.h});
                }
                maxHeap.add(e.h);
            } else {    // leave
                maxHeap.remove(e.h);    //PQ remove() 操作O(n)
                if (maxHeap.size() == 0) {
                    ans.add(new int[]{e.x, 0});
                }
                else if (e.h > maxHeap.peek()) {
                    ans.add(new int[]{e.x, maxHeap.peek()});
                }
            }
        }
        return ans;      
    }
    
    
    class Event {
        int x;  //横坐标
        int h;
        int type;
        public Event(int x, int h, int t) {
            this.x = x;
            this.h = h;
            this.type = t;
        }
    }
}