class Solution {
    public int minFlipsMonoIncr(String s) {

        int[] flip = new int[s.length() + 1];
        int[] leftOnes = new int[s.length() + 1];
        int[] rightZeros = new int[s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            leftOnes[i] = leftOnes[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        for (int i = s.length()-2; i >= 0; i--) {
            rightZeros[i] = rightZeros[i+1] + (s.charAt(i+1) == '0' ? 1 : 0);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < flip.length; i++) {
            flip[i] = leftOnes[i] + rightZeros[i];
            res = Math.min(flip[i], res);
        }
        return res;
    }
}