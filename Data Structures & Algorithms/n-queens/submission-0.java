class Solution {
    private List<List<String>> result = new ArrayList<>(); 

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, n);
        return result;
    }

    private void backtrack(int row, char[][] board, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(row + 1, board, n);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // check row
        for (int r = 0; r < n; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        // check left upper
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // check right upper
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
