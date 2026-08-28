class Solution {
    class TreeNode {
        TreeNode[] children = new TreeNode[26];
        String word;
    }

    private TreeNode root = new TreeNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }

    private void insert(String word) {
        TreeNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TreeNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }

    private void dfs(char[][] board, int r, int c, TreeNode node) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        char ch = board[r][c];
        if (ch == '#') {
            return;
        }
        TreeNode next = node.children[ch - 'a'];
        if (next == null) {
            return;
        }
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        dfs(board, r+1, c, next);
        dfs(board, r-1, c, next);
        dfs(board, r, c+1, next);
        dfs(board, r, c-1, next);

        board[r][c] = ch;
        return;
    }
}
