class Solution {
public int longestStrChain(String[] words) {
    int res = 0;
    Arrays.sort(words, (a,b)-> a.length()-b.length());  // Sort the words based on their lengths
    HashMap<String, Integer> map = new HashMap();       //Stores each word and length of its max chain.

    for(String w : words) {                             //From shortest word to longest word
        map.put(w, 1);  
        //Each word is atleast 1 chain long
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() + 1 < w.length()) continue;
            if (words[i].length() + 1 > w.length()) break;
            if (valid(words[i], w)) {
                map.put(w, Math.max(map.get(w), map.get(words[i]) + 1));
            }
        }
        res = Math.max(res, map.get(w));                //Store max length of all chains
    }
    return res;
}

private boolean valid(String a, String b) {
    if (a.length() + 1 != b.length()) return false;
    int count = 0;
    
    for (int i = 0, j = 0; i < a.length() && j < b.length();) {
      if (a.charAt(i) == b.charAt(j)) {
        ++i; ++j;
      } else { 
        ++count; ++j; 
      }
    }
    return count <=1;
  }
}
