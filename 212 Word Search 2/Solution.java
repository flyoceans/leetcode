class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        TrieNode trie = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(ans, board, i, j, trie);
            }
        }
        return ans;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                } 
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
    
    private void dfs(List<String> ans, char[][] board, int i, int j, TrieNode trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        int x = board[i][j] - 'a';
        if (trie.next[x] == null) {
            return;
        }
        trie = trie.next[x];
        if (trie.word != null) {
            ans.add(trie.word);
            trie.word = null; // de-duplicate
            // return;
        }
        
        char c = board[i][j];
        board[i][j] = '#';
        dfs(ans, board, i+1, j, trie);
        dfs(ans, board, i-1, j, trie);
        dfs(ans, board, i, j+1, trie);
        dfs(ans, board, i, j-1, trie);
        board[i][j] = c;
        return;
    }
    
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}