/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
*/
class Solution {
    public int lengthOfLastWord(String s) {
        String[] res;
        res = s.split(" ");
        for(int i=res.length-1;i>=0;i--){
            if(res[i].length() > 0)
                return res[i].length();
        }
        return 0;
    }
}
