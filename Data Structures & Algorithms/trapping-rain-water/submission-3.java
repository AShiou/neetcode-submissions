class Solution {
    public int trap(int[] height) {
        int sum = 0;

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
                right--;
            }
        }

        return sum;
    }
}