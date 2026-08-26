class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 1. for loop each row, each column, each sub-boxes -> O(n^4) = O(n^4), Space one hashset O(1)
        // 2. for loop once, and use 27 hashset 
        // choose 2
        // 0,0 1,0 2,0, 3,0 4,0 5,0, 6,0 7,0 8,0
        // 0,1 1,1 2,1,
        // 0,2 1,2 2,2,
        // 0,3 1,3 2,3
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.') continue;
                int boxIndex = (i / 3) * 3 + j / 3;
                if (!rows[i].add(val) || !cols[j].add(val) || !boxes[boxIndex].add(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
