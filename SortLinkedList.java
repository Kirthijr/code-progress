/*
Given the head of a linked list, return the list after sorting it in ascending order.

Input: head = [4,2,1,3]
Output: [1,2,3,4] 
*/
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode mid = head, end = head, temp1 = head;
        if(head == null || head.next == null) return head;
        while(end != null && end.next != null){
                temp1 = mid;
                mid = mid.next;     
                end = end.next.next;   
        }
        temp1.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
       return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), temp = l;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l.next = l1;
                l = l.next;
                l1 = l1.next;

            }else{
                l.next = l2;
                l = l.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            l.next = l1;
        if(l2 != null)
            l.next = l2;
        return temp.next;
    }
}
