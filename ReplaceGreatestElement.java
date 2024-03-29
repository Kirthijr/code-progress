/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, 
and replace the last element with -1. After doing so, return the array.
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1], temp;
        arr[arr.length-1] = -1;
        for(int i =arr.length-2;i>=0;i--){
            temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
