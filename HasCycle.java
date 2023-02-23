//Find if the linked list contains a cycle

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode ptr1 = head, ptr2 = head;
        while(ptr1 != null && ptr2 != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if(ptr2 != null && ptr2.next != null)
                ptr2 = ptr2.next;
            else
                return false;
            if(ptr1 != null && ptr1 == ptr2)
                return true;
        }
        return false;
    }
}
