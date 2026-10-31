class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, int start, String word) {
        if (start == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        if (board[r][c] == '#') {
            return false;
        }
        char ch = board[r][c];
        if (ch != word.charAt(start)) {
            return false;
        }
        board[r][c] = '#';
        boolean found = backtrack(board, r + 1, c, start + 1, word)
                    || backtrack(board, r - 1, c, start + 1, word)
                    || backtrack(board, r, c + 1, start + 1, word)
                    || backtrack(board, r, c - 1, start + 1, word);
        board[r][c] = ch;
        return found;
    }
}
