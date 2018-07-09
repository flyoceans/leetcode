class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int candy1 = 0, candy2 = 1;
        int cnt1 = 0, cnt2 = 0;
        for (int m : nums) {
            
            if (candy1 == m) {
                cnt1++;
            } else if (candy2 == m) {
                cnt2++;
            } else if (cnt1 == 0) {
                candy1 = m;
                cnt1++;
            } else if (cnt2 == 0) {
                candy2 = m;
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int m : nums) {
            if (m == candy1) cnt1++;
            else if (m == candy2) cnt2++;
        }
        // System.out.println(candy1 + " " + candy2);
        if (cnt1 > nums.length/3) ans.add(candy1);
        if (cnt2 > nums.length/3) ans.add(candy2);
        return ans;
    }
}