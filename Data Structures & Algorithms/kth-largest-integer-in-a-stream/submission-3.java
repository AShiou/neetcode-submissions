class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            if (minHeap.size() == k) {
                if (minHeap.peek() >= num) {
                    continue;
                } else {
                    minHeap.poll();
                }
            }
            minHeap.offer(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() == k) {
            if (minHeap.peek() >= val) {
                return minHeap.peek();
            }
            minHeap.poll();
        }
        minHeap.offer(val);
        return minHeap.peek();
    }
}
