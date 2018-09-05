class MovingAverage {

    Queue<Integer> queue;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (queue.size() < this.size) {
            queue.add(val);
            sum += val;
        } else {
            sum -= queue.poll();
            queue.add(val);
            sum += val;
        }

        return (double)sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */