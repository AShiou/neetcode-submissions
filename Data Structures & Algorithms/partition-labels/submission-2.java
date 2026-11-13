class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        int i = 0;
        while (i < s.length()) {
            int start = i;
            Map<Character, Integer> map = new HashMap<>();
            while (!map.isEmpty() || i == start) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                if (map.get(c) == countMap.get(c)) {
                    map.remove(c);
                }
                i++;
                if (i == s.length()) {
                    break;
                }
            }
            result.add(i - start);
        }
        return result;
    }
}
