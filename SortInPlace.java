/*
Sort the integers 0, 1, and 2 in place.
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

*/
class Solution {
    public void sortColors(int[] nums) {
        int ptr1 = 0, ptr2 = 0, ptr3 = nums.length-1, temp;
        while(ptr2 <= ptr3){
            if(nums[ptr2] == 0){
                temp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = temp;
                ptr1++;
                ptr2++;
            }else if(nums[ptr2] == 1)
                ptr2++;
            else{
                temp = nums[ptr3];
                nums[ptr3] = nums[ptr2];
                nums[ptr2] = temp;
                ptr3--;
            }
        }
    }
}
