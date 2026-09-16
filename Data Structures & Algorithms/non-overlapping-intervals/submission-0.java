class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int remove = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                end = interval[1];
            } else {
                // 把 end 在後的刪除
                remove++;
            }
        }
        return remove;
    }
}
