class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    max = Math.max(max, dfs(r, c, visited, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, boolean[][] visited, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        return dfs(r+1, c, visited, grid) 
            + dfs(r-1, c, visited, grid)
            + dfs(r, c+1, visited, grid)
            + dfs(r, c-1, visited, grid)
            + 1;
    }
}
