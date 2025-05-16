class Solution {
    public int largestRectangleArea(int[] heights) {
            
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int prev = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(width* heights[prev], max);
            }            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            int width = stack.isEmpty() ? heights.length : (heights.length - stack.peek() - 1);
            max = Math.max(width * heights[prev], max);
        }
        
        return max;
    }
}