class StockSpanner {
    Deque<Pair<Integer, Integer>> stack; 
    
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price) {
            res += stack.pop().getValue();
        }
        stack.push(new Pair(price, res));
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */