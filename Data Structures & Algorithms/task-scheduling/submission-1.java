class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(freq[i]);
            }
        }
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int count = maxHeap.poll();
                    count--;
                    if (count > 0) {
                        temp.add(count);
                    }
                }
                time++;
                if (maxHeap.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }
            for (int count : temp) {
                maxHeap.offer(count);
            }
        }
        return time;
    }
}
