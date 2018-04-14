class Solution {
    public int hammingDistance(int x, int y) {
        int tmp = (x ^ y);
        System.out.println(tmp);
        int sum = 0;
        while (tmp != 0) {
            tmp &= tmp-1;
            sum++;
        }
        return sum;
    }
}