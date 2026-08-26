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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }
        ListNode result = l1;
        ListNode prev = null;
        int addOne = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + addOne;
            if (sum >= 10) {
                l1.val = sum - 10;
                addOne = 1;
            } else {
                l1.val = sum;
                addOne = 0;
            }
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            prev.next = l2;
            l1 = prev.next;
        }
        while (l1 != null) {
            int sum = l1.val + addOne;
            if (sum >= 10) {
                l1.val = sum - 10;
                addOne = 1;
            } else {
                l1.val = sum;
                addOne = 0;
            }
            prev = l1;
            l1 = l1.next;
        }
        if (addOne == 1) {
            prev.next = new ListNode(1);
        }
        return result;
    }
}
