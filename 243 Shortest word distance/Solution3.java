class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE, i1 = -1, i2 = -1;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            if (i1 != -1 && i2 != -1)
                dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;

    }
}