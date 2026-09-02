class Solution {
    private int row;
    private int col;

    private int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        this.row = heights.length;
        this.col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // from up
        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, pacific);
        }

        // from left
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, pacific);
        }

        // from down
        for (int i = col - 1; i >= 0; i--) {
            dfs(heights, row - 1, i, atlantic);
        }

        // from right
        for (int i = row - 1; i >= 0; i--) {
            dfs(heights, i, col - 1, atlantic);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue;
            }
            if (!visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
