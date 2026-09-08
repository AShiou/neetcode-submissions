class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // dp[i] 當作前i個字元的dp 
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i ++) {
            // 1 digit
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            // 2 digits
            if (i >= 2) {
                char first = s.charAt(i - 2);
                char second = s.charAt(i - 1);
                if (first == '1' || (first == '2' && second <= '6')) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
