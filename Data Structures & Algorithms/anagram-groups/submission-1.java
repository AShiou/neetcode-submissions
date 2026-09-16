class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(sorted, tmp);
            }
        }
        return new ArrayList<>(map.values());
    }
}
