/*
Given an integer x, return true if x is a palindrome, and false otherwise.
Input: x = 121
Output: true
*/

class Solution {
    public boolean isPalindrome(int x) {
        boolean res = true;
        if(x<0){
            return false;
        }
        int reverseX = reverseInt(x);
        if(reverseX == x){
            return true;
        }else{
            return false;
        }
        
    }
    public int reverseInt(int x){
        int reverse = 0,i;
        while(x!=0){
            i = x%10;
            reverse = reverse*10 + i;
            x = x/10;
        }
        return reverse;
    }
}
