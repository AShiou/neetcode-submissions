class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row
        for (int row = 0; row < board.length; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
