/*
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, temp, c=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[c--] = nums1[i--];
            }else
                nums1[c--] = nums2[j--];
        }
        while(i>=0 && c>=0){
            nums1[c--] = nums1[i--];
        }
        while(j>=0 && c>=0){
            nums1[c--] = nums2[j--];
        }

    }
}
