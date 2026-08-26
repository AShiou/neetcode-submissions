class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int res = 0;
        char[] arr = s.toCharArray();
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(arr[i]));
            
            while ((i - left + 1) - maxFreq > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
