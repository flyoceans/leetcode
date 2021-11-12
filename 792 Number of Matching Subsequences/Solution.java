class Solution {
    // Binary search lower bound
  private Map<Character, List<Integer>> pos;
  private boolean isMatch(String word) {
    int l = -1;
    for (char c : word.toCharArray()) {
        if (!pos.containsKey(c)) return false;
        List<Integer> p = pos.get(c);
        int index = Collections.binarySearch(p, l + 1);
        if (index < 0) index = -index - 1;
        if (index >= p.size()) return false;
        l = p.get(index);
    }
    return true;
  }
  
  public int numMatchingSubseq(String S, String[] words) {
    pos = new HashMap<>();

    for (int i = 0; i < S.length(); ++i) {
        pos.putIfAbsent(S.charAt(i), new ArrayList<>());
        pos.get(S.charAt(i)).add(i);
    }

    int ans = 0;
    for (String word : words)
      if (isMatch(word)) ++ans;
    return ans;
  }
}