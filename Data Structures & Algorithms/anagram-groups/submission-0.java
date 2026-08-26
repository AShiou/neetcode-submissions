class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sort string and as map key, value is string array -> strs.length * nlogn
        // anagram -> array
        // another thinking: 26 letters array -> as key -> strs.length * (n + 26)
        Map<String, List<String>> anagramGroups = new HashMap<>();
        int baseChar = 'a';
        int[] letterCount = new int[26];
        for (String word : strs) {
            Arrays.fill(letterCount, 0);
            for (char c: word.toCharArray()) {
                letterCount[c - baseChar]++;
            }
            String key = Arrays.toString(letterCount);
            anagramGroups.computeIfAbsent(key, v -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}