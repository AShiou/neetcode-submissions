class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int sellMax = prices[len - 1];
        int max = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] < sellMax) {
                max = Math.max(sellMax - prices[i], max);
            } else {
                sellMax = Math.max(sellMax, prices[i]);
            }
        }
        return max;
    }
}
