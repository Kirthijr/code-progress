/*
Given an array of integers nums which is sorted in ascending order, 
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
*/
class Solution {
    public int search(int[] nums, int target) {
        return ss(0, nums.length-1, nums, target);
    }
    public int ss(int low, int high, int[] nums, int target){
        int mid = high-low/2;
        if(low <= high){
            if(nums[mid] == target)
                return mid;
            if(nums[mid]> target)
                return ss(low, mid-1, nums, target);
            else
                return ss(mid+1, high, nums, target);
        }
        else
            return -1;
    }
