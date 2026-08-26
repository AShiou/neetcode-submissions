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
    public boolean hasCycle(ListNode head) {
        ListNode runner1 = head;
        ListNode runner2 = head;
        while (runner2 != null && runner2.next != null) {
            runner1 = runner1.next;
            runner2 = runner2.next.next;
            if (runner1 == runner2) {
                return true;
            }
        }
        return false;
    }
}
