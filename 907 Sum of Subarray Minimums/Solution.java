class Solution {
    public int sumSubarrayMins(int[] arr) {
        /**
            For A[i], assuming there are L numbers that are greater than A[i] in range A[0] ~ A[i – 1], 
            and there are R numbers that are greater or equal than A[i] in the range of A[i+1] ~ A[n – 1]. 
            Thus A[i] will be the min of (L + 1) * (R + 1) subsequences.
            e.g. A = [3,1,2,4], A[1] = 1, L = 1, R = 2, there are (1 + 1) * (2 + 1) = 6 subsequences are 1 is the min number. 
            [3,1], [3,1,2], [3,1,2,4], [1], [1,2], [1,2,4]

            leftDist[i]: from arr[i] to the left, how many element greater than arr[i]
            rightDist[i]: from arr[i] to the right, how many element less or equal than arr[i]
        */
        int n = arr.length;
        int[] leftDist = new int[n];
        int[] rightDist = new int[n];
        
        Deque<int[]> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // >= for duplicate case: 1A, 1B -> 1A < 1B
            // monotic increasing stack
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                stack.pop();
            }
            leftDist[i] = i - 1 - (stack.isEmpty() ? -1 : stack.peek()[1]);
            stack.push(new int[]{arr[i], i});
        }
        // for (int i : leftDist)
        //     System.out.print(i + " ");
        
        stack.clear();
        
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                stack.pop();
            }
            rightDist[i] = (stack.isEmpty() ? arr.length : stack.peek()[1]) - 1 - i;
            stack.push(new int[]{arr[i], i});
        }

        // for (int i : rightDist)
        //     System.out.print(i + " ");
        
        long sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            long tmp = (leftDist[i] + 1) * (rightDist[i] + 1) % mod;
            sum = (sum + arr[i] * tmp) % mod;
        }
        return (int) (sum % mod);
    }
}