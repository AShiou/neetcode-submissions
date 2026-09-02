class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph[prerequisiteCourse].add(course);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<Integer>[] graph, int[] visited) {
        if (visited[course] == 1) {
            return false;
        }
        // 已確認沒有 cycle
        if (visited[course] == 2) {
            return true;
        }
        visited[course] = 1;
        for (int next : graph[course]) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
}
