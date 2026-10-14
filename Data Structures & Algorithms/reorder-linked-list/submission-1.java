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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;
        
        ListNode first = head;
        while (second != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            first.next = second;
            second.next = nextFirst;

            first = nextFirst;
            second = nextSecond;
        }

    }

    private ListNode reverse(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode head = node;
        while (node.next != null) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
