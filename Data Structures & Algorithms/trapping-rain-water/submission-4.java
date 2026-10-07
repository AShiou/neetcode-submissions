class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                if (height[left] < leftMax) {
                    sum = sum + leftMax - height[left];
                } else {
                    leftMax = Math.max(height[left], leftMax);
                }
            } else {
                right--;
                if (height[right] < rightMax) {
                    sum = sum + rightMax - height[right];
                } else {
                    rightMax = Math.max(height[right], rightMax);
                }
            }
        }
        return sum;
    }
}
