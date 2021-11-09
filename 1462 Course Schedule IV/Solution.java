class Solution {
    // a->b
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        boolean[][] g = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            g[pre[0]][pre[1]] = true;
        }

        // The order of k, i, j cant change. K must be in the outermost loop.
        // Floyd-Warshall algo, the approach of the algorithm is DP.
        for (int k = 0; k < g.length; k++) 
            for (int i = 0; i < g.length; i++) 
                for (int j = 0; j < g.length; j++) 
                    g[i][j] |= g[i][k] && g[k][j];
                
        for (int[] query : queries) {
            res.add(g[query[0]][query[1]]);
            // res.add(check(g, query[0], query[1]));
        }
        return res;
    }
    
//     boolean check(boolean[][] g, int s, int e) {
//         if (g[s][e]) return true;
        
//         for (int i = 0; i < g.length; i++) {
//             if (!g[s][i]) continue;
//             if (check(g, i, e)) {
//                 g[s][e] = true;
//                 return true;
//             }
//         }
//         return false;
//     }
}