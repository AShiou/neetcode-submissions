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

        for (int row = 0; row < board.length; row = row + 3) {
            for (int col = 0; col < board[row].length; col = col + 3) {
                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[row + i][col + j] == '.') {
                            continue;
                        }
                        if (set.contains(board[row + i][col + j])) {
                            return false;
                        }
                        set.add(board[row + i][col + j]);
                    }
                }
            }
        }
        return true;
    }
}
