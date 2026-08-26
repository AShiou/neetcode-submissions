class Solution {
    public boolean isAnagram(String s, String t) {
        // same characters, only letters?
        // lowercase English letters
        // integer array with size 26
        if (s.length() != t.length()) {
            return false;
        }
        int baseChar = 'a';
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            counts[c - baseChar]++;
        }
        for (char c: t.toCharArray()) {
            if (counts[c - baseChar] < 1) {
                return false;
            }
            counts[c - baseChar]--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
