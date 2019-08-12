class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] pre = nums.clone();
        Arrays.sort(pre);
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < pre.length; i++) {
            if (!map.containsKey(pre[i])) {
                map.put(pre[i], j++);
            }
        }
        
        int[] fenwick = new int[map.size()+1];
        // int[] res = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length-1; i >= 0; i--) {
            int index = map.get(nums[i]);
            // System.out.println(index);
            res.add(query(fenwick, index-1));
            update(fenwick, index);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    private void update(int[] fenwick, int index) {
        index++;
        while (index < fenwick.length) {
            fenwick[index] += 1;
            index += (index & (-index));
        }
    }
    
    private int query(int[] fenwick, int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += fenwick[index];
            index -= (index & (-index));
        }
        return sum;
    }
}