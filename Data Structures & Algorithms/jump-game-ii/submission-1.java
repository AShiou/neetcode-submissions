class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i && dp[j] != Integer.MAX_VALUE) {
                    min = Math.min(dp[j] + 1, min);
                }
            }
            dp[i] = min;
        }
        return dp[nums.length - 1];
    }
}
