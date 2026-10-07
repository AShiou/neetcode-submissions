class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            boolean leftSmaller = heights[left] <= heights[right];
            int width = right - left;
            if (leftSmaller) {
                max = Math.max(heights[left] * width, max);
                left++;
            } else {
                max = Math.max(heights[right] * width, max);
                right--;
            }
        }
        return max;
    }
}
