class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robFrom(0, n - 2, nums), robFrom(1, n - 1, nums));
    }

    private int robFrom(int start, int end, int[] nums) {
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[start + 1]);
        for (int j = start + 2; j <= end; j++) {
            int temp = Math.max(prev1 + nums[j], prev2);
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
}
