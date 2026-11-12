class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int j = 0;
        int[] result = new int[queries.length];
        for (int[] query : sortedQueries) {
            int q = query[0];
            int index = query[1];
            while (j < intervals.length && intervals[j][0] <= q) {
                minHeap.offer(intervals[j]);
                j++;
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            result[index] = minHeap.isEmpty() ? -1 : minHeap.peek()[1] - minHeap.peek()[0] + 1;
        }
        return result;
    }
}
