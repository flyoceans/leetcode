class Solution {
    public int majorityElement(int[] nums) {
        int X = 0; 
        int i = 0;
        for (int m : nums) {
            if (i == 0) {
                X = m;
                i++;
            } else if (X == m) {
                i++;
            } else {
                i--;
            }
        }
        return X;
    }
}