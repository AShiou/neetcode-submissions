/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();
        queue.offer(node);
        Node result = new Node(node.val);
        map.put(node, result);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            Node copyTmp = map.get(tmp);
            for (Node n : tmp.neighbors) {
                if (!map.containsKey(n)) {
                    Node copyN = new Node(n.val);
                    map.put(n, copyN);
                    queue.offer(n);
                }
                copyTmp.neighbors.add(map.get(n));
            }
        }
        return result;
    }
}