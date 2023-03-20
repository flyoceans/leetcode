class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = wordList.stream().collect(Collectors.toSet());
        
        if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                
                char[] array = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char tmp = array[j];
                    for (char a = 'a'; a <= 'z'; a++) {
                        array[j] = a;
                        String newWord = new String(array);
                        if (set.contains(newWord)) {
                            queue.add(newWord);
                        }
                        set.remove(newWord);
                        
                    }
                    array[j] = tmp;
                }
            }
            res++;
        }
        return 0;
    }

}