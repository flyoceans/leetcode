class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lower = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            int tmp = preorder[i];
            if (tmp < lower)
                return false;
            if (stack.isEmpty()) {
                stack.push(tmp);
            } else if (stack.peek() < tmp) {
                lower = stack.pop();
                while (!stack.isEmpty() && stack.peek() < tmp) {
                    lower = stack.pop();
                }
                stack.push(tmp);
            } else {
                stack.push(tmp);
            }
        }
        return true;
    }
}