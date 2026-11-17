class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r != 0 && c!= 0 && r != m - 1 && c != n - 1) {
                    continue;
                }
                if (board[r][c] == 'O') {
                    queue.offer(new int[]{r, c});
                    board[r][c] = '#';
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1]; 
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                        continue;
                    }
                    if (board[dx][dy] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{dx, dy});
                    board[dx][dy] = '#';
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if(board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
