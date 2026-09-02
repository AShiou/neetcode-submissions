class Solution {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        // 每個 node 一開始都是自己
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (find(a) == find(b)) {
                return edge;
            }
            union(a, b);
        }
        return new int[0];
    }

    private int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }
}
