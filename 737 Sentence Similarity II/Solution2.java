class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        
        Map<String, String> parents = new HashMap<>();
        for (List<String> pair : similarPairs) {
            parents.putIfAbsent(pair.get(0), pair.get(0));
            parents.putIfAbsent(pair.get(1), pair.get(1));
            union(parents, pair.get(0), pair.get(1));
        }
        
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && !isConnected(parents, sentence1[i], sentence2[i])) return false;
        }
        return true;
    }
    
    void union(Map<String, String> parents, String a, String b) {
        String pa = find(parents, a);
        String pb = find(parents, b);
        if (!pa.equals(pb)) parents.put(pa, pb);
    }
    
    boolean isConnected(Map<String, String> parents, String a, String b) {
        return parents.containsKey(a) && parents.containsKey(b) && find(parents, a).equals(find(parents, b));
    }
    
    String find(Map<String, String> parents, String a) {
        if (parents.get(a) != a) {
            parents.put(a, find(parents, parents.get(a)));
        }
        return parents.get(a);
    }
}