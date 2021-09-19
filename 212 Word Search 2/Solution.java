class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
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
        if (trie != null && trie.word != null) {
            ans.add(trie.word);
            trie.word = null;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || trie.next[board[i][j] - 'a'] == null) {
            return;
        }
        
        char c = board[i][j];
        board[i][j] = '#';
        dfs(ans, board, i+1, j, trie.next[c - 'a']);
        dfs(ans, board, i-1, j, trie.next[c - 'a']);
        dfs(ans, board, i, j+1, trie.next[c - 'a']);
        dfs(ans, board, i, j-1, trie.next[c - 'a']);
        board[i][j] = c;
        return;
    }
    
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
        TrieNode(){};
    }
}
    