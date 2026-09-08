class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            int count = map.get(c);
            if (count < 1) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }
}