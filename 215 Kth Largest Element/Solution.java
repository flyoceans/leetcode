class Solution {
    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return (int)(b - a);
            }
        });
        for (int n : nums) {
            queue.add(n);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }
}