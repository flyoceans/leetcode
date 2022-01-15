class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (word.charAt(i) - 'a');
            if (p.children[index] == null)
                p.children[index] = new TrieNode();
            p = p.children[index];
        }
        p.is_word = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (word.charAt(i) - 'a');
            if (p.children[index] != null)
                p = p.children[index];
            else return false;
        }
        return p.is_word;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (prefix.charAt(i) - 'a');
            if (p.children[index] != null)
                p = p.children[index];
            else return false;
        }
        return true;
    }
    
    class TrieNode {
        public TrieNode() {
            children = new TrieNode[26];
            is_word = false;
        }
        public boolean is_word;
        public TrieNode[] children;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */