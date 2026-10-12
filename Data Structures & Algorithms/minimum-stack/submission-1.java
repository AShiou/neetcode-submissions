class MinStack {

    private ArrayDeque<Integer> stackVal;
    private ArrayDeque<Integer> stackMinVal;

    public MinStack() {
        stackVal = new ArrayDeque<>();
        stackMinVal = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stackVal.push(val);
        if (!stackMinVal.isEmpty()) {
            stackMinVal.push(Math.min(stackMinVal.peek(), val));
        } else {
            stackMinVal.push(val);
        }
    }
    
    public void pop() {
        stackVal.pop();
        stackMinVal.pop();
    }
    
    public int top() {
        return stackVal.peek();
    }
    
    public int getMin() {
        return stackMinVal.peek();
    }
}
