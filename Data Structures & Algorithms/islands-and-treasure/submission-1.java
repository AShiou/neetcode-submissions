class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] treasure = queue.poll();
                int x = treasure[0];
                int y = treasure[1];
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= grid.length 
                        || dy < 0 || dy >= grid[0].length
                        || grid[dx][dy] != Integer.MAX_VALUE) {
                            continue;
                    }
                    grid[dx][dy] = distance + 1;
                    queue.offer(new int[]{dx, dy});
                }
            }
            distance++;
        }
    }
}
