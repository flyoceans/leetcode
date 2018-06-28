class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 1 TreeSet
        // TreeSet<Long> tree = new TreeSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     Long floor = tree.floor((long)nums[i] + t);
        //     Long ceiling = tree.ceiling((long)nums[i] - t);
        //     if (floor != null && floor >= nums[i] ||
        //        ceiling != null && ceiling <= nums[i])
        //         return true;
        //     tree.add((long)nums[i]);
        //     if (i >= k)
        //         tree.remove((long)nums[i-k]);
        // }
        // return false;
        // 2 Bucket
        if (t < 0 || k < 1)
            return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], t);
            // System.out.println(id);
            if (map.containsKey(id))
                return true;
            // map.getOrDefault()
            if (map.containsKey(id-1) && Math.abs(nums[i] - map.get(id-1)) <= t
               || map.containsKey(id+1) && Math.abs(nums[i] - map.get(id+1)) <= t) {
                return true;
            }
            map.put(id, (long)nums[i]);
            if (i >= k)
                map.remove(getId(nums[i-k], t));
        }
        return false;
    }
    
    private long getId(int x, int t) {
        return x < 0 ? x / (long)(t+1) - 1: x / (long)(t+1);
    }
}