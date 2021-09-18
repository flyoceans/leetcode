class Solution {
    public int racecar(int target) {
        if (target == 0) return 0;
        Status start = new Status(0, 1);
        
        Queue<Status> queue = new LinkedList<>();
        queue.add(start);
        int steps = 0;
        Set<Status> visited = new HashSet<>();
        visited.add(start);
        
        while (!queue.isEmpty()) {
            // steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Status tmp = queue.poll();
                if (tmp.pos == target) return steps;
                Status next = new Status(tmp.pos + tmp.speed, tmp.speed * 2);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
                next = new Status(tmp.pos, tmp.speed > 0 ? -1 : 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
            steps++;
        }
        return -1;
    }
    
    
    
    class Status {
        int pos;
        int speed;
        Status(int p, int s) {
            this.pos = p;
            this.speed = s;
        }
        
        @Override
    public int hashCode() {
        return pos*33+speed;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
    Status u=(Status) obj;
        return (u.pos == pos) && (u.speed == speed);
    }
    }
}