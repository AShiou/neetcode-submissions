class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int buyMin = prices[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > buyMin) {
                max = Math.max(prices[i] - buyMin, max);
            } else {
                buyMin = Math.min(buyMin, prices[i]);
            }
        }
        return max;
    }
}
