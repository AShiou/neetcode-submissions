class Solution {
    public int evalRPN(String[] tokens) {
        // for loop
        // number: push
        // operator: pop 2 numbers, and then push
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || 
                token.equals("-") || 
                token.equals("*") ||
                token.equals("/")) {
                    int second = stack.pop();
                    int first= stack.pop();
                    if (token.equals("+")) {
                        stack.push(first + second);
                    } else if (token.equals("-")) {
                        stack.push(first - second);
                    } else if (token.equals("*")) {
                        stack.push(first * second);
                    } else if (token.equals("/")) {
                        stack.push(first / second);
                    }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
