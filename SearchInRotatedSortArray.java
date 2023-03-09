/*
Given a rotated sorted array in increasing order, return if the target exists in the array

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        
        while(start <= end)
        {
           int mid = start + (end-start)/2;
           if(nums[mid] == target)
            return true;
            if(nums[mid] == nums[end])
                end--;
            else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }else{
                if(target > nums[mid] && target <= nums[end])   
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return false;
    }
}
