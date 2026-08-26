class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c: t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        char[] sArr = s.toCharArray();
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < sArr.length; right++) {
            if (freqMap.containsKey(sArr[right])) {
                freqMap.put(sArr[right], freqMap.get(sArr[right]) - 1);
                if (freqMap.get(sArr[right]) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if (freqMap.containsKey(sArr[left])) {
                    freqMap.put(sArr[left], freqMap.get(sArr[left]) + 1);
                    if (freqMap.get(sArr[left]) > 0) {
                        count--;
                    }
                }
                left++;
            } 
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
