class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                stack.pollLast();
            }
            stack.addLast(i);
            if (stack.peekFirst() + k <= i) stack.pollFirst();
            if (i - k + 1 >= 0) res[i - k + 1] = nums[stack.peekFirst()];
        }
        
        return res;
    }
}