class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = Math.max(nums[i], dp[i - 1] + nums[i])
        int answer = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            answer = Math.max(answer, current);
        }

        return answer;
    }
}
