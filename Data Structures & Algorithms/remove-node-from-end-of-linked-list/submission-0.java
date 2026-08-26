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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode runToTail = dummy;
        for (int i = 0; i <= n; i++) {
            runToTail = runToTail.next;
        }
        while (runToTail != null) {
            prev = prev.next;
            runToTail = runToTail.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
