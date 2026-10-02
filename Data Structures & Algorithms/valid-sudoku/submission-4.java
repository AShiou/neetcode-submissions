class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '1';
                if (row[i][val]) {
                    return false;
                }
                row[i][val] = true;

                if (col[j][val]) {
                    return false;
                }
                col[j][val] = true;

                int boxIndex = (i / 3) * 3 + (j / 3);
                if (box[boxIndex][val]) {
                    return false;
                }
                box[boxIndex][val] = true;
            }
        }
        return true;
    }
}
