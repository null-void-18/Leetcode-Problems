//61. Rotate List


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
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        if(head == null || head.next == null || k == 0) return head;

        ListNode start = head,prev = null;

        while(head != null) {
            count += 1;
            head = head.next;
        }
        if(k == count || k % count == 0) {
            return start;
        }
        count -= (k % count);
        head = start;

        for(int i = 0; i < count;i++) {
            prev = head;
            head = head.next;
        }

        prev.next = null;
        prev = head;
        while(head != null && head.next != null) {
            head = head.next;
        }

        head.next = start;

        return prev;
    }
}
