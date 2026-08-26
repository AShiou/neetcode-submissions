class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = 
            new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] point : points) {
            minHeap.add(point);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k ; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    private int distance(int[] point) {
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}
