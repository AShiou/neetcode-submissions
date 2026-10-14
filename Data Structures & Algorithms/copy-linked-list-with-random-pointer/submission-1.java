/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node curCopy = dummy;
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            curCopy.next = tmp;
            map.put(cur, tmp);
            curCopy = curCopy.next;
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node tmp = map.get(cur);
            if (cur.random == null) {
                tmp.random = null;
            } else {
                tmp.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
