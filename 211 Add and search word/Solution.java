class WordDictionary {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    public boolean search(String word, int index, TrieNode node) {
        if (word.length() == index)
            return node.isEnd();
        
        // for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(index);
           if (curLetter == '.') {
               for (char c = 'a'; c <= 'z'; c++) {
                   if (node.get(c) != null) {
                        if (search(word, index+1, node.get(c)))
                            return true;
                   }
               }
           } else {
               if (node.containsKey(curLetter)) {
                   return search(word, index+1, node.get(curLetter));
               } else {
                   return false;
               }
           }
        // }
        return false;
    }

}

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public TrieNode[] getLinks() {
        return links;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */