/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices,
and return the reordered list.
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head, temp1 = null, temp2, prev = null;
        if(head == null || head.next == null) return head;
        temp2 = head.next;
        temp1 = temp2;
        while(head != null && head.next != null){
            prev = head;
            head.next = temp1.next;
            head = head.next;
            if(head != null){
                temp1.next = head.next;
                temp1 = temp1.next;
            }else{
                head = prev;
            }
        }
        head.next = temp2;
        return temp;
    }
}
