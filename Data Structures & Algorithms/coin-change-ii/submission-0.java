class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // dp[i] 代表可以有幾種方式組成 i 元
        for (int coin : coins) {
            for (int i = coin ; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
