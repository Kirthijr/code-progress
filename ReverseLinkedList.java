// Given the head of a singly linked list, reverse the list, and return the reversed list.

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp, next = null;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = next;
            next = temp;
            
        }
        return next;
    }
}
