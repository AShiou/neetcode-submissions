class KthLargest {

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num: nums) {
            minHeap.add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
