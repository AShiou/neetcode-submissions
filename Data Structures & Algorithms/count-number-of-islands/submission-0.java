class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == '1') {
                    count++;
                    dfs(grid, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int m, int n) {
        if (m < 0 || m >= grid.length ||
            n < 0 || n >= grid[0].length) {
            return;
        }

        if (grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m + 1, n);
        dfs(grid, m - 1, n);
        dfs(grid, m, n + 1);
        dfs(grid, m, n - 1);
    }
}
