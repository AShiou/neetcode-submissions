/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = getKth(cur, k);
            if (tmp == null) {
                break;
            }
            for (int i = 1; i < k; i++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = tail.next;
                tail.next = next;
            }
            tail = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode node, int k) {
        for (int i = 1; i < k; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
