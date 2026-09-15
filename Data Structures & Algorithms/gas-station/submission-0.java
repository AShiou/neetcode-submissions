class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total = gas[i] - cost[i] + total;
        }

        if (total < 0) {
            return -1;
        }

        int current = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            current = current + diff;
            if (current < 0) {
                current = 0;
                result = i + 1;
            }
        }
        return result;
    }
}
