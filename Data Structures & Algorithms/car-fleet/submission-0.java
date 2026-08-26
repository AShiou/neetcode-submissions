class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // first
        // 1 -> 4 -> 7 -> 10
        // 4 -> 6 -> 8 -> 10
        // second
        // 4 -> 6 -> 8 -> 10
        // 1 -> 3 -> 5 -> 7
        // 0 -> 1 -> 2 -> 3
        // 7 -> 8 -> 9 -> 10
        double[][] positions = new double[position.length][2];
        // 因為不能超車，所以前面位置的一定會先到
        for (int i = 0; i < position.length; i++) {
            positions[i][0] = position[i];
            positions[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(positions, (a, b) -> Double.compare(b[0], a[0]));
        int fleets = 0;
        double maxTime = 0;
        for (int i = 0; i < position.length; i++) {
            if (maxTime < positions[i][1]) {
                maxTime = positions[i][1];
                fleets++;
            }
        }
        return fleets;
    }
}
