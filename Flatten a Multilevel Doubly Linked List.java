//430. Flatten a Multilevel Doubly Linked List

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

        Node flattenChild(Node head,Node end,Node curr) {
            curr.prev = head;
            head.next = head.child;
            Node prev = curr;
            head.child = null;
            while(curr != null) {
                if(curr.child != null) {
                    curr = flattenChild(curr,curr.next,curr.child);
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = end;
            if(end != null) {
            end.prev = prev;
            }
            return prev;
        }

    public Node flatten(Node head) {
        Node start = head;
        while(head != null) {
            if(head.child != null) {
                head = flattenChild(head,head.next,head.child);
            }
            head = head.next;
        }
        return start;
    }
}
