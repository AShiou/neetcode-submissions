class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 代表前 n 個字能不能被拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i - wordLen >= 0 && dp[i - wordLen] && s.substring(i - wordLen, i).equals(word)) {
                    dp[i] = dp[i - wordLen];
                }
            }
        }
        return dp[n];
    }
}
