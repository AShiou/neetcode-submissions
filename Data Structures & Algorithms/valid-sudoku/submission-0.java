class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. for loop each row, each column, each sub-boxes -> O(n^2) = O(n^2), Space one hashset O(1)
        // 2. for loop once, and use 27 hashset 
        // choose 1
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (set.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (set.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // 0,0 1,0 2,0, 3,0 4,0 5,0, 6,0 7,0 8,0
        // 0,1 1,1 2,1,
        // 0,2 1,2 2,2,
        // 0,3 1,3 2,3
        for (int i = 0; i < 9; i = i+3) {
            for (int j = 0; j < 9; j = j+3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (set.contains(board[k][l])) {
                            return false;
                        }
                        if (board[k][l] != '.') {
                            set.add(board[k][l]);
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
