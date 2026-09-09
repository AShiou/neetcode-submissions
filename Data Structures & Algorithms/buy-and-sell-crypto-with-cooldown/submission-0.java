class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            int newHold = Math.max(hold, rest - price);
            int newSold = hold + price;
            int newRest = Math.max(rest, sold);

            hold = newHold;
            sold = newSold;
            rest = newRest;
        }
        return Math.max(rest, sold);
    }
}
