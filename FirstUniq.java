// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

class Solution {
    public int firstUniqChar(String s) {
     int arr[] = new int[256];
     for(int i=0;i<s.length();i++){
         arr[s.charAt(i)] ++;
     }   
     for(int i=0;i<s.length();i++){
        if( arr[s.charAt(i)] == 1)
            return i;
     } 
     return -1;
    }
}
