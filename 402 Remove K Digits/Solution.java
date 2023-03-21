class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && Character.getNumericValue(stack.peek()) > Character.getNumericValue(num.charAt(i))) {
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        while(k > 0) {
            k--;
            stack.pop();
        }

         StringBuilder sb = new StringBuilder();
         while(!stack.isEmpty()) sb.append(stack.pop());
         while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}