class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0] + 1, b[1] - b[0] + 1));

        int[] result = new int[queries.length];

        int i = 0;

        for (int[] q : sortedQueries) {
            int query = q[0];
            int originalIndex = q[1];

            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(intervals[i]);
                i++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            if(minHeap.isEmpty()) {
                result[originalIndex] = -1;
            } else {
                int[] interval = minHeap.peek();
                result[originalIndex] = interval[1] - interval[0] + 1;
            }
        }

        return result;
    }
}
