//25. Reverse Nodes in k-Group


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

    ListNode reverse(ListNode begin,ListNode head,ListNode end) {
        ListNode prev = end;
        ListNode curr = begin.next,temp = begin.next;
        begin.next = head;
        while(curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return temp;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        if(k == 1 || head == null || head.next == null) return head;
        ListNode begin = dummy;
        ListNode end;
        int i = 0;
        while(head != null) {
            i++;
            if(i%k == 0) {
                end = head.next;
                head = reverse(begin,head,end);
                begin = head;
            }
                head = head.next;
        }
        return dummy.next;
    }
}
