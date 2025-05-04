class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // O(N)
        Map<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);
        int curSum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += (nums[i] % 2);
            prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
            if (prefixSum.containsKey(curSum - k)) {
                res += prefixSum.get(curSum - k);
            }
        }
        return res;

        // Brutal O(n^2) time out
        // int[] prefixSum = new int[nums.length+1];
        // for (int i = 1; i <= nums.length; i++) {
        //     prefixSum[i] = prefixSum[i-1] + (nums[i-1] % 2);
        // }

        // int res = 0;
        // for (int j = 1; j <= nums.length; j++) {
        //     for (int i = 0; i < j; i++) {
        //         if (prefixSum[j] - prefixSum[i] == k)
        //             res++;
        //     }
        // }
        // return res;


    }
}