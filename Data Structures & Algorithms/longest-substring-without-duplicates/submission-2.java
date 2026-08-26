class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            while(set.contains(arr[i])) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[i]);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
