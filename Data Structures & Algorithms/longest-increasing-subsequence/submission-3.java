class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            result = Math.max(len, result);
        }
        return result;
    }
}
