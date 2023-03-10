// Given a linked list return a random node everytime. All nodes should have the possibility to return

class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public Solution(ListNode head) {
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        double random = Math.random()*list.size();
        return list.get((int)random);
    }
}
