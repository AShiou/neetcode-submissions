class Solution {
    public int evalRPN(String[] tokens) {
        // for loop
        // number: push
        // operator: pop 2 numbers, and then push
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int second = stack.pop();
                    int first= stack.pop();
                    stack.push(first - second);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int div2 = stack.pop();
                    int div1 = stack.pop();
                    stack.push(div1 / div2);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
