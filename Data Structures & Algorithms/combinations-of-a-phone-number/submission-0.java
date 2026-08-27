class Solution {
    private String[] phone = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = phone[digits.charAt(index) - '0'];

        for (char letter: letters.toCharArray()) {
            path.append(letter);
            backtrack(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
