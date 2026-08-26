class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                max = Math.max(heights[left] * (right - left), max);
                left++;
            } else {
                max = Math.max(heights[right] * (right - left), max);
                right--;
            }
        }
        return max;
    }
}
