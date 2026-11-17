class Solution {

    private int islands = 0;

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(r, c, grid, visited);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        if (r < 0 
            || r >= grid.length 
            || c < 0 
            || c >= grid[0].length 
            || visited[r][c]
            || grid[r][c] == '0') {
            return;
        }
        visited[r][c] = true;
        dfs(r+1, c, grid, visited);
        dfs(r-1, c, grid, visited);
        dfs(r, c+1, grid, visited);
        dfs(r, c-1, grid, visited);
    }
}
