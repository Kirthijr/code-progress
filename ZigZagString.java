/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

*/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        
        StringBuilder res = new StringBuilder();
        int cyclen = 2*numRows - 2;
        for(int i=0;i<numRows;i++){
            for(int j=0;i+j<s.length();j+=cyclen){
                res.append(s.charAt(i+j));
                if(i!=0 && i != numRows-1 && j+cyclen-i < s.length()){
                    res.append(s.charAt(j+cyclen-i));
                }
            }
        }
        return res.toString();
    }
}
