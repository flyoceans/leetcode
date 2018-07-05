class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            // if (c == ' ')
            //    continue;
            if (Character.isDigit(c)) {
                num = num*10 + (int)(c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == array.length-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num);
                } else {
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = c;
            }
        }
        
        
        int ans = 0;
        for (int i : stack) {
            ans += i;
        }
        return ans;
    }
}