class HitCounter {
    // Queue<Integer> queue;
    int[] time;
    int[] cnt;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        // queue = new LinkedList<>();
        time = new int[300];
        cnt = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        // queue.add(timestamp);
        int index = timestamp % 300;
        if (time[index] != timestamp) {
            time[index] = timestamp;
            cnt[index] = 1;
        } else {
            cnt[index]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        // while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
        //     queue.poll();
        // }
        // return queue.size();
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                res += cnt[i];
            } 
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */