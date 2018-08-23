class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] letter = new int[26];
        int cnt = 0;
        int maxCnt = 0;
        for (char c : tasks) {
            letter[c - 'A']++;
            if (letter[c - 'A'] > maxCnt) {
                maxCnt = letter[c - 'A'];
                cnt = 1;
            } else if (letter[c - 'A'] == maxCnt) {
                cnt++;
            }
        }
        return Math.max(tasks.length, (maxCnt-1)*(n+1) + cnt);
    }
}