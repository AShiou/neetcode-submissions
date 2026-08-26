class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 30, 38, 30, 36, 35, 40, 28
        // brute force: O(n^2)
        // stack 40, 28
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                int index = indexStack.pop();
                result[index] = i - index;
            }
            indexStack.push(i);
        }
        while (!indexStack.isEmpty()) {
            int index = indexStack.pop();
            result[index] = 0;
        }
        return result;
    }
}
