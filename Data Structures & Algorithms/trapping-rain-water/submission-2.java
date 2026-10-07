class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                left[i] = 0;
                continue;
            }
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                right[i] = 0;
                continue;
            }
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] <= height[i] || right[i] <= height[i]) {
                continue;
            }
            sum = sum + Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
