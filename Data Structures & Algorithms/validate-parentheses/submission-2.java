class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char left = stack.pop();
            if ((left == '{' && c != '}') ||
                (left == '[' && c != ']') ||
                (left == '(' && c != ')')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
