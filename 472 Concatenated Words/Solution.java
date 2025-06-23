class Solution {
    // O(n^4)
     public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        // obvious that a word can only be formed by words shorter than it. 
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }

    // time O(n^3) since java substring method will take O(n) time
    public boolean wordBreak(String s, Set<String> set) {
        // Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // private boolean dfs(String word, int cur, boolean[] visited, Set<String> dictionary) {
    //     if (cur == word.length()) {
    //         return true;
    //     }
    //     if (visited[cur]) {
    //         return false;
    //     }
    //     visited[cur] = true;
    //     for (int i = word.length() - (cur == 0 ? 1 : 0); i > cur; i--) {
    //         if (dictionary.contains(word.substring(cur, i)) 
    //             && dfs(word, i, visited, dictionary)) {
    //             return true;
    //         }
            
    //     }
    //     return false;
    // }
    
    // public List<String> findAllConcatenatedWordsInADict(String[] words) {
    //     Set<String> dictionary = new HashSet<>(Arrays.asList(words));
    //     List<String> answer = new ArrayList<>();
    //     for (String word : words) {
    //         int length = word.length();
    //         boolean[] visited = new boolean[length];
    //         if (dfs(word, 0, visited, dictionary)) {
    //             answer.add(word);
    //         }
    //     }
    //     return answer;   
    // }
}