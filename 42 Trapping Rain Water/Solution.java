class Solution {
    public int trap(int[] height) {
        // two pointer
//         int l = 0, r = height.length-1;
        
//         int left_max = height[l], right_max = height[r];
        
//         int res = 0;
        
//         while (l < r) {
//             if (height[l] < height[r]) {
//                 if (left_max > height[l]) {
//                     res += left_max - height[l];
//                 }
//                 left_max = Math.max(height[l], left_max);
//                 l++;
//             } else {
//                 if (right_max > height[r]) {
//                     res += right_max - height[r];
//                 } 
//                 right_max = Math.max(height[r], right_max);
//                 r--;
//             }
//         }
        
//         return res;
        
        //  monotonic decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // if (height[i] == 0) stack.clear(); 高度为 0 漏水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int prev = stack.pop();
                if (stack.isEmpty()) continue; // 左边没有墙了
                
                int h = Math.min(height[stack.peek()], height[i]) - height[prev];
                int width = i - stack.peek() - 1;
                res += h * width;
            }
            
            stack.push(i);
        }
        return res;
    }
}