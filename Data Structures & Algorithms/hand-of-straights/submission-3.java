class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int h : hand) {
            if (countMap.containsKey(h)) {
                countMap.put(h, countMap.get(h) + 1);
            } else {
                countMap.put(h, 1);
            }
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int h : countMap.keySet()) {
            minHeap.offer(h);
        }
        while (!minHeap.isEmpty()) {
            int current = minHeap.peek();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < groupSize; i++) {
                if (minHeap.isEmpty() || current != minHeap.poll()) {
                    return false;
                }
                countMap.put(current, countMap.get(current) - 1);
                if (countMap.get(current) > 0) {
                    temp.add(current);
                }
                current++;
            }
            for (int t : temp) {
                minHeap.offer(t);
            }
        }
        return true;
    }
}
