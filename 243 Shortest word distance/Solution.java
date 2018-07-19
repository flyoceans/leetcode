class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[k];
        if (k == 1)
            return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                deque.addLast(nums[i]);
                continue;
            }
            if (nums[i] <= deque.peekLast()) {
                deque.addLast(nums[i]);
            } else {
                int cnt = 0;
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                    cnt++;
                }
                while (cnt > 0) {
                    deque.addLast(nums[i]);
                    cnt--;
                }
                deque.addLast(nums[i]);
            }
            if (i + 1 >= k)
                ans[i - k + 1] = deque.removeFirst();
        }
        // ans[nums.length-k] = deque.removeFirst();
        return ans;
    }
}