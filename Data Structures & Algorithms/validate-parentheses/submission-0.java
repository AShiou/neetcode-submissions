class Solution {
    public boolean isValid(String s) {
        // for loop 
        // left bracket: push
        // right bracket: pop the left and check if it can be matched the right
        // O(n)
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (left == '(' && c != ')') {
                    return false;
                }
                if (left == '[' && c != ']') {
                    return false;
                }
                if (left == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
