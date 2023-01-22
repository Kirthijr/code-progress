// Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length; i++){
        if(pq.contains(nums[i]))
            continue;
        else if(pq.size() < 3){
            pq.add(nums[i]);
        }
        else if(pq.size() > 0 && pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        if(pq.size() < 3){
            while(pq.size() > 1)
                pq.poll();
        }
        return pq.size() != 0 ? pq.peek() : -1;
    }
}
