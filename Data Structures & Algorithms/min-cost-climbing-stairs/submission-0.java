class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        int prev1 = cost[0];
        int prev2 = cost[1];
        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i] + cost[i - 2], cost[i] + cost[i - 1]);
        }
        return Math.min(cost[n - 2], cost[n - 1]);
    }
}
