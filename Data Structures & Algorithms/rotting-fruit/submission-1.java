class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 
                        || dx >= grid.length 
                        || dy < 0 
                        || dy >= grid[0].length
                        || grid[dx][dy] != 1) {
                        continue;
                    }
                    freshCount--;
                    if (freshCount == 0) {
                        return distance;
                    }
                    grid[dx][dy] = 2;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
        return -1;
    }
}
