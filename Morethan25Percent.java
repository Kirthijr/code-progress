/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array 
that occurs more than 25% of the time, return that integer.
*/
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, count = 0, prev;
        if(n < 4)
            return arr[0];
        for(int i=0;i<n-1;i++){
            if(i+n/4 < n && arr[i] == arr[i+n/4])
                return arr[i];
        }
        return -1;
    }
}
