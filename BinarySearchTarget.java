/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = binarySearch(target, 0, nums.length-1, nums, true);
        res[1] = binarySearch(target, 0, nums.length-1, nums, false);
        return res;
    }
    public int binarySearch(int target, int start, int end, int[] nums, boolean isStart){
        if(nums.length == 0 || (nums[start] == nums[end] && nums[start] != target)) return -1;
        if(start >= 0 && end < nums.length){
            int mid = start + (end-start)/2;
            if(nums[mid] < target) 
                return binarySearch(target, mid+1, end, nums, isStart);
            else if(nums[mid] > target) 
                return binarySearch(target, start, mid-1, nums, isStart);
            else{
                if(isStart){
                    while(mid-1 >=0 && nums[mid-1] == target){
                        mid--;
                    }
                }else{
                    while(mid+1 < nums.length && nums[mid+1] == target)
                        mid++;
                }
                return mid;
            }
        }
        else 
            return -1;
    }
}
