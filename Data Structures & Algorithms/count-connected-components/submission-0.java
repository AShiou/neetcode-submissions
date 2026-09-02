class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        visited[i] = true;
        for (int adj : graph.get(i)) {
            if (!visited[adj]) {
                dfs(graph, visited, adj);
            }
        }
    }
}
