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
        // 1. go through
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse
        ListNode list2 = reverseLinkedList(slow.next);
        slow.next = null;
        
        // 3. merge
        ListNode list1 = head;
        while (list2 != null) {
            ListNode list1Next = list1.next;
            ListNode list2Next = list2.next;
            list1.next = list2;
            list2.next = list1Next;
            list1 = list1Next;
            list2 = list2Next;
        }
    }

    ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}