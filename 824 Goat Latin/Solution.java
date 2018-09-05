class Solution {
    public String toGoatLatin(String S) {
        
        Set<Character> set = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
            set.add(c);
        StringBuilder ans = new StringBuilder();
        String tail = "ma";
        for (String word : S.split(" ")) {
            StringBuilder sb = new StringBuilder();
            if (!set.contains(word.charAt(0))) {
                sb.append(word.substring(1));
                sb.append(word.substring(0, 1));
            } else {
                sb.append(word);
            }
            // System.out.println(word.charAt(0));
            tail += "a";
            sb.append(tail);
            ans.append(sb.toString() + " ");
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }
}