class Solution {
    // Merge sort
    public int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    private int[] sortArray(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};

        int mid = left + (right - left)/2;

        int[] l = sortArray(nums, left, mid);
        int[] r = sortArray(nums, mid+1, right);
        return merge(l, r);
    }

    private int[] merge(int[] l, int[] r) {
        int[] res = new int[l.length + r.length];
        int i = 0, j = 0;
        for (; i < l.length && j < r.length;) {
            if (l[i] <= r[j]) {
                res[i+j] = l[i++];
            } else {
                res[i+j] = r[j++];
            }
        }
        if (i == l.length) {
            for (; j < r.length; j++) {
                res[i+j] = r[j];
            }
        } 
        if (j == r.length) {
            for (; i < l.length; i++) {
                res[i+j] = l[i];
            }
        } 
        
        return res;
    }
}