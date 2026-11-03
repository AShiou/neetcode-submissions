class Solution {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        backtrack(matrix, 0, n);
        return result;
    }

    private void backtrack(char[][] matrix, int row, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                solution.add(new String(matrix[i]));
            }
            result.add(solution);
        }
        for (int i = 0; i < n; i++) {
            if (isValid(matrix, row, i, n)) {
                matrix[row][i] = 'Q';
                backtrack(matrix, row + 1, n);
                matrix[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] matrix, int r, int c, int n) {
        // check vertical
        for (int i = 0; i < r; i++) {
            if (matrix[i][c] == 'Q') {
                return false;
            }
        }
        // check left upper
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // check right upper
        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
