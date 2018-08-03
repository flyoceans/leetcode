class Solution {
    public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < n) {
            int min = Math.min(list.get(i)*2, Math.min(list.get(j)*3, list.get(k)*5));
            list.add(min);
            if (list.get(i)*2 == min) i++;
            if (list.get(j)*3 == min) j++;
            if (list.get(k)*5 == min) k++;
        }
        return list.get(list.size()-1);
    }
}