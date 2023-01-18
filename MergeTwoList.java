/*You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = null;
        ListNode head = null;
        ListNode n = null;
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        if( l1.val > l2.val){
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        n = l1;
        // n.next = null;
        head = n;
        temp = n;
        l1 = l1.next;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                n = l1;
                // n.next = null;
                temp.next = n;
                l1 = l1.next;
            }else{
                n = l2;
                // n.next = null;
                temp.next = n;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }
         if(l2 != null){
            temp.next = l2;
        }
        return head;
    }
}
