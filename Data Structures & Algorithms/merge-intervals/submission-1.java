class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!result.isEmpty() && intervals[i][0] <= result.get(j - 1)[1]) {
                result.get(j - 1)[1] = Math.max(result.get(j - 1)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
