class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            pacific[r][0] = true;
            queue.offer(new int[]{r, 0});
        }
        for (int c = 0; c < n; c++) {
            pacific[0][c] = true;
            queue.offer(new int[]{0, c});
        }
        bfs(pacific, heights, queue);

        for (int r = m - 1; r >= 0; r--) {
            atlantic[r][n - 1] = true;
            queue.offer(new int[]{r, n - 1});
        }
        for (int c = n - 1; c >= 0; c--) {
            atlantic[m - 1][c] = true;
            queue.offer(new int[]{m - 1, c});
        }
        bfs(atlantic, heights, queue);
        List<List<Integer>> result = new ArrayList<>(); 
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void bfs(boolean[][] sea, int[][] heights, Queue<int[]> queue) {
        int m = heights.length;
        int n = heights[0].length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n || sea[dx][dy]) {
                        continue;
                    }
                    if (heights[dx][dy] >= heights[x][y]) {
                        queue.offer(new int[]{dx, dy});
                        sea[dx][dy] = true;
                    }
                }
            }
        }
    }
}
