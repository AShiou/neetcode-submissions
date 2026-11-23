class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int c1 = countFromCenter(s, i, i);
            int c2 = countFromCenter(s, i, i + 1);
            count = count + c1 + c2;
        }
        return count;
    }

    private int countFromCenter(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length()
            && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                count++;
        }
        return count;
    }
}
