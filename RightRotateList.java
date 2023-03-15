/*
Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
*/

//Form a circular linked list and rotate k values and remove the loop
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        if(head == null || head.next == null || k == 0) return temp;
        while(temp != null && temp.next != null){
            temp = temp.next;
            count++;
        }
        temp.next = head;
        k = k%(count+1);
        k = count + 1 - k;
        for(int i=0;i<k;i++)
            temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
