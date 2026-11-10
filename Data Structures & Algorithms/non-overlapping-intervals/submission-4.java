class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = new int[2];
        prev[0] = intervals[0][0];
        prev[1] = intervals[0][1];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                if (intervals[i][1] < prev[1]) {
                    prev[0] = intervals[i][0];
                    prev[1] = intervals[i][1];
                }
                removed++;
            } else {
                prev[0] = intervals[i][0];
                prev[1] = intervals[i][1];
            }
        }
        return removed;
    }
}
