class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 1) {
            return maxHeap.peek();
        } else {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
