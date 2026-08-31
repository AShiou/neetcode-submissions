class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                max = Math.max(max, dfs(grid, m, n));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length ||
            n < 0 || n >= grid[0].length) {
            return 0;
        }
        if (grid[m][n] == 0) {
            return 0;
        }
        grid[m][n] = 0;
        return dfs(grid, m + 1, n) + dfs(grid, m - 1, n) + dfs(grid, m, n + 1) + dfs(grid, m, n - 1) + 1;
    }
}
