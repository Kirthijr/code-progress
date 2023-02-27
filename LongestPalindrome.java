// Given a string s, return the longest palindromic substring in s.

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int st=0,e=0;
        String res="";
        for(int i=0;i<s.length();i++){
            int l1 = palLength(s,i,i);
            int l2 = palLength(s,i,i+1);
            int l = Math.max(l1,l2);
            if(l > e - st){
                st = i-(l-1)/2;
                e = i+l/2;
            }
        }
        return s.substring(st,e+1);
    }
    public int palLength(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
    
}
/*
Given a string s which consists of lowercase or uppercase letters, return the length 
of the longest palindrome that can be built with those letters.
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.


class Solution {
    public int longestPalindrome(String s) {
        int result=0;
        int[] arr=new int[128];
        for(char c:s.toCharArray()){
            arr[c]++;
        }

        for(int val: arr){
            result += val/2 * 2;

            if(result % 2 == 0 && val % 2 == 1)
                result++;
        }
        return result;
    }
}
