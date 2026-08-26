class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxFreq = 0;
        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int maxCount = 0;
        for (int freq: count) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        int result = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(result, tasks.length);
    }
}
