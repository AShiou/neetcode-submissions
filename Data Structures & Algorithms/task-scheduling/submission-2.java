class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        int maxFreq = 0;
        int countMax = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                countMax++;
            } else if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                countMax = 1;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax);
    }
}
