class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmpResult = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0] || newInterval[0] > interval[1]) {
                tmpResult.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        int[][] result = new int[tmpResult.size() + 1][2];
        int i = 0;
        boolean added = false;
        for (int[] interval : tmpResult) {
            if (!added && newInterval[0] < interval[0]) {
                result[i] = newInterval;
                added = true;
                i++;
            }
            result[i] = interval;
            i++;
        }
        if (!added) {
            result[i] = newInterval;
        }
        return result;
    }
}
