class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return result;
    }

    private void backtrack(int left, int right, int n, StringBuilder path) {
        if (left == n && right == n) {
            result.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            backtrack(left + 1, right, n, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (right + 1 <= left) {
            path.append(')');
            backtrack(left, right + 1, n, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}