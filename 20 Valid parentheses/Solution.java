class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '[' || tmp == '{' || tmp == '(') {
                stack.push(tmp);
            } else if (!stack.isEmpty()) {
                char c = stack.pop();
                
                if (c == '[' && tmp == ']'|| c == '{' && tmp == '}'|| c == '(' && tmp == ')')
                    continue;
                else 
                    return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}