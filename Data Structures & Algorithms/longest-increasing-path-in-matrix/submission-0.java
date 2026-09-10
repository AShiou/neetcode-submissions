class Solution {
    private int[][] matrix;
    private int[][] memo;
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.memo = new int[rows][cols];

        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result = Math.max(result, dfs(r, c));
            }
        }

        return result;
    }

    private int dfs(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int maxLength = 1;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }

            if (matrix[nr][nc] <= matrix[r][c]) {
                continue;
            }

            maxLength = Math.max(maxLength, 1 + dfs(nr, nc));
        }

        memo[r][c] = maxLength;
        return maxLength;
    }
}
