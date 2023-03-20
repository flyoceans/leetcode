class Solution {
    public int numSquarefulPerms(int[] A) {
        boolean visited[] = new boolean[A.length];
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(A);
        helper(result, A, new ArrayList<>(), visited);
        return result.size();
    }
    
    public void helper(List<List<Integer>> result, int A[], List<Integer> path, boolean visited[]) {
        if(path.size() == A.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = 0; i < A.length; i++) {
            if(visited[i] || (i > 0 && A[i] == A[i - 1] && !visited[i - 1]))
                continue;

            if(path.size() > 0 && !isSquare(A[i], last_number))
                continue;

            path.add(A[i]);
            visited[i] = true;
            helper(result, A, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
    
    public boolean isSquare(int a, int b) {
        return (Math.sqrt(a + b) % 1) == 0;
    }
}