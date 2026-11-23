class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (cur != 0) {
                dp[i] += dp[i - 1];
            }
            if (prev == 1 || (prev == 2 && cur < 7)) {
                if (i - 2 < 0) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n - 1];
    }
}
