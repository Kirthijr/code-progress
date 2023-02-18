/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Input: s = "III"
Output: 3
Explanation: III = 3.

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
import java.util.*;
class Solution {
    public int romanToInt(String s) {
        int res = 0, prev = 0, v;
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for(int i=s.length()-1;i>=0;i--){
            v = roman.get(s.charAt(i));
            //roman should be in increasing order, subtract if lesser value roman comes before greater value roman
            if(v < prev)
                res = res - v;
            else
            res = res + v;
            prev = v;
        }
    return res;
    }
}
