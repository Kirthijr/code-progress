/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list 
that has Node.val == val, and return the new head.
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode temp = head, t;
        
        while(head != null && head.next != null){
            t = head.next;
            while(t != null && t.val == val){
                head.next = t.next;
                t = t.next;
            }
            head = head.next;
        }
        return temp;
    }
}
