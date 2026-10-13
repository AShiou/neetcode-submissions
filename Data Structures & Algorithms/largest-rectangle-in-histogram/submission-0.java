class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int rightH = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > rightH) {
                int h = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, h * width);
            }
            stack.push(i);
        }
        return max;
    }
}
