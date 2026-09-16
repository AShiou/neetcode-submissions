class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                map.put(key, group);
            }
        }
        return new ArrayList<>(map.values());
    }
}
