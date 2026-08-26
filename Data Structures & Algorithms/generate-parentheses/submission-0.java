class Solution {
    public List<String> generateParenthesis(int n) {
        // n = 1
        // ()
        // n = 2
        // (()), ()()
        // 2o2c, 1o1c1o1c
        // n = 3
        // 3o3c, 2o2c1o1c, 2o1c1o2c, 1o1c2o2c, 1o1c1o1c1o1c
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private void backtrack(StringBuilder cur, int open, int close, int n, List<String> result) {
        if (open == n && close == n) {
            result.add(cur.toString());
            return;
        }

        // put (
        if (open < n) {
            cur.append('(');
            backtrack(cur, open + 1, close, n, result);
            cur.deleteCharAt(cur.length() - 1);
        }

        // put )
        if (close < open) {
            cur.append(')');
            backtrack(cur, open, close + 1, n, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
