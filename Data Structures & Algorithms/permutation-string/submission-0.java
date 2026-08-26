class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqArr = new int[26];
        for (char c: s1.toCharArray()) {
            freqArr[c - 'a']++;
        }
        int left = 0;
        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            int index = s2Arr[i] - 'a';
            freqArr[index]--;
            while (freqArr[index] < 0) {
                freqArr[s2Arr[left] - 'a']++;
                left++;
            }
            if (i - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
