class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                while (left < i) {
                    if (arr[left] == arr[i]) {
                        left++;
                        break;
                    } else {
                        set.remove(arr[left]);
                        left++;
                    }
                }
            } else {
                set.add(arr[i]);
                max = Math.max(max, i - left + 1);
            }
        }
        return max;
    }
}
