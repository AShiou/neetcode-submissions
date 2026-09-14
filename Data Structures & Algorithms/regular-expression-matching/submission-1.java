class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j]: s的前 i 個字元，可被 p 的前 j 個字元 match
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // s = ""，只有像 a*, a*b*, a*b*c* 這種可以 match
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 普通字元 or .
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                // *
                } else {
                    // ex. a* -> * match 到 0 次
                    dp[i][j] = dp[i][j - 2];
                    // * match 次數 >= 1
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
