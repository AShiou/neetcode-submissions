class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len; 
        }
        int[] count = new int[26];
        int maxCount = 0;
        int result = 0;
        int left = 0;
        for (int right = 0; right < len; right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
