class Solution {
    public boolean isStrobogrammatic(String num) {
        // "8" or "69" or "0" "1"
        char[] arr = num.toCharArray();
        int l = 0, r = num.length()-1;
        while (l < r) {
            if (!Character.isDigit(arr[l]) || !Character.isDigit(arr[r]))
                return false;
            if (arr[l] == '0' || arr[l] == '1' || arr[l] == '8') {
                if (arr[l] != arr[r])
                    return false;
            }
            else if (arr[l] == '6' && arr[r] == '9' || arr[l] == '9' && arr[r] == '6') {
                
            } else {
                return false;
            }
            l++;
            r--;
        }
        if (l == r) {
            return arr[l] == '0' || arr[l] == '1' || arr[l] == '8';
        }
        return true;
    }
}