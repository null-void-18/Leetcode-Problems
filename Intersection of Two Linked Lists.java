//160. Intersection of Two Linked Lists


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        ListNode a = list1, b = list2;

        if(a == null || b == null) return null;

        while(a != b) {
            a = a == null ? list2 : a.next;
            b = b == null ? list1 : b.next;
        }
        return a;
    }
}
