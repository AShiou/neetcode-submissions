class Solution {

    private List<String> result = new ArrayList<>();
    private Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('0', List.of());
        map.put('1', List.of());
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, int start, StringBuilder path) {
        if (start == digits.length()) {
            result.add(path.toString());
            return;
        }
        List<Character> letters = map.get(digits.charAt(start));
        for (char letter : letters) {
            path.append(letter);
            backtrack(digits, start + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
