class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int curr = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (curr == -1 || minDist[j] < minDist[curr])) {
                    curr = j;
                }
            }
            visited[curr] = true;
            result = result + minDist[curr];

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[curr][0] - points[j][0]) +
                                Math.abs(points[curr][1] - points[j][1]);
                    minDist[j] = Math.min(minDist[j], dist);
                }
            }
        }
        return result;
    }
}
