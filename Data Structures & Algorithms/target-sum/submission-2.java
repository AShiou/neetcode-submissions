class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        // 假設 P 是所有加號的總和，N 是所有減號的總和
        // P - N = target
        // P + N = total
        // P = (target + total) / 2
        if ((target + total) % 2 != 0) {
            return 0;
        }

        int sum = (target + total) / 2;

        // dp[i] 代表可以組合成 i 的方法數
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[sum];
    }
}
