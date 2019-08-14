class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0)
            return res;
        Set<String> set = wordList.stream().collect(Collectors.toSet());
        Map<String, Integer> distance = wordList.stream().collect(Collectors.toMap(x -> x, x -> Integer.MAX_VALUE));
        
        Queue<List<String>> queue = new LinkedList<>();
        List<String> ans = new ArrayList<>(); 
        ans.add(beginWord);
        distance.put(beginWord, 1);
        queue.add(ans);
        
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> list = queue.poll();
                String word = list.get(list.size()-1);
                if (word.equals(endWord)) {
                    flag = true;
                    res.add(new ArrayList(list));
                }
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);
                    for (int k = 0; k < 26; k++) {
                        if (c != (char)(k + 'a')) {
                            String tmp = word.substring(0, j) + (char)(k + 'a') + word.substring(j+1);
                            if (set.contains(tmp) && distance.get(word) < distance.get(tmp)) {
                                List<String> newList = new ArrayList(list);
                                newList.add(tmp);
                                queue.add(newList);
                                distance.put(tmp, distance.get(word) + 1);
                            }
                        }
                    }
                }
                set.remove(word);
            }
        }
        return res;
    }
}