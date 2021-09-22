class Solution {
    // TSP NP-C problem
    // dp[s][j]: min distance of travelling nodes in set s and ending at node j.
    // s is bitmask
    // dp[14][2]: min distance of travelling nodes {1, 2, 3} and ending at 2.
    // s = 1110, 2^1 + 2^2 + 2^3
    // g[i][j]: the cost of appending j after i. (gcta, ctaagt) = 3
    // dp[s][j] = min{dp[s][i] + g[i][j]}
    // return min{dp[2^n - 1][*]}
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] graph = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = cal(words[i], words[j]);
                graph[j][i] = cal(words[j], words[i]);
            }
        }
        
        int[][] dp = new int[(1 << n)][n];
        int[][] parent = new int[1 << n][n];
        
        for (int s = 1; s < (1 << n); s++) 
            for (int j = 0; j < n; j++)
                dp[s][j] = 1000;
        for (int i = 0; i < n; i++) dp[1 << i][i] = words[i].length();
// System.out.println( 1 << 0) : 1;
        for (int s = 1; s < (1 << n); s++) {
            for (int j = 0; j < n; j++) {
                if (s == (1 << j)) continue; // only node j itself.
                int ps = s & ~(1 << j);
 
                for (int i = 0; i < n; i++) {
                    // if (i == j) continue;
                    if (dp[ps][i] + graph[i][j] < dp[s][j]) {
                        dp[s][j] = dp[ps][i] + graph[i][j];
                        parent[s][j] = i;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE, last = -1;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] < min) {
                min = dp[(1 << n) - 1][i];
                last = i;
            }
        }
        // build the path
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<>();
        while (cur > 0) {
            stack.push(last);
            int temp = cur & ~(1 << last);
            last = parent[cur][last];
            cur = temp;
        }
        
        // build the result
        int i = stack.pop();
        sb.append(words[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(words[j].substring(words[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }
    
    int cal(String a, String b) {
        int res = b.length();
        for (int i = 1; i < Math.min(a.length(), b.length()); i++) {
            if (a.substring(a.length() - i).equals(b.substring(0, i))) res = b.length() - i;
        }
        return res;
    }
}