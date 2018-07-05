class MyStack {
    Queue<Integer> q1;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = q1.size();
        while (n > 1) {
            q1.add(q1.poll());
            n--;
        }
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int n = q1.size();
        while (n > 1) {
            q1.add(q1.poll());
            n--;
        }
        int ans = q1.peek();
        q1.add(q1.poll());
        return ans;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */