class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int tmp = Math.min(cost[i - 2] + prev1, cost[i - 1] + prev2);
            prev1 = prev2;
            prev2 = tmp;
        }
        return prev2;
    }
}
