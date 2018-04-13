class Solution {
    //不像dp问题？ 暴力搜TLE
    //基本思路 dp[i][k] 表示到达第ith石头时，用的是k units， 那么下一步就是[k-1, k+1]units，动归方程不好写
    //看了答案用hashmap替代dp[][].
//  暴力解法
//     public boolean canCross(int[] stones) {
//         int k = 0;
//         return helper(stones, 0, k);
//     }

//     private boolean helper(int[] stones, int index, int k) {
//         if (index == stones.length - 1) 
//             return true;
//         for (int i = k - 1; i <= k + 1; i++) {
//             int nextJump = stones[index] + i;
//             //看接下来有没有合适的石头可以跳过去，从接下来的位置中查找有没有nextJump的位置，有的话返回石头的编号
//             int nextPosition = Arrays.binarySearch(stones, index + 1, stones.length, nextJump);
//             if (nextPosition > 0) {
//                 if (helper(stones, nextPosition, i)) return true;
//             }
//         }
//         return false;
//     }
       public boolean canCross(int[] stones) {
           //map{key : value} 表示position值为key，可以通过value步到达key点。
           HashMap<Integer, Set<Integer>> map = new HashMap<>();
           for (int i : stones) {
               map.put(i, new HashSet<Integer>());
           }
           map.get(0).add(0);
           for (int i = 0; i < stones.length; i++) {
               for (int k : map.get(stones[i])) {
                   for (int j = k-1; j <= k+1; j++) {
                       if (j > 0 && map.containsKey(stones[i] + j))
                        map.get(stones[i] + j).add(j);
                   }
               }
           }
           return map.get(stones[stones.length-1]).size() > 0;
       }
}