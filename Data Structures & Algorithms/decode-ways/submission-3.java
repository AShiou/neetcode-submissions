class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int cur = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (cur != 0) {
                dp[i] += dp[i - 1];
            }
            if (prev == 1 || (prev == 2 && cur <= 6)) {
                dp[i] += (i >= 2) ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }
}
