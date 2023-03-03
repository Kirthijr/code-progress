/*
A valid IP address consists of exactly four integers separated by single dots. 
Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
*/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<String>();
        recurring(list, s, "", "", 0);
        return list;
    }

    public void recurring(List<String> res, String remaining, String value,String ipAddress, int count){
        // Each value should be less than 255 with no leading zero
        if((value.length()>2 && Integer.parseInt(value) > 255) || (value.length()>1 && value.charAt(0) == '0')) return;
        //therre should be only 4 integers
       if(count>4 ) return;

        //add the value to the ipAddress
       ipAddress += value;

        //add the ipAddress if the remaining string is empty
       if(remaining.length() == 0 && count == 4) res.add(ipAddress);

        //append . to the ipAddress
       if(value.length() > 0) ipAddress += ".";

       if(remaining.length()>0) 
        recurring(res, remaining.substring(1,remaining.length()), remaining.substring(0,1), ipAddress, count+1);
       if(remaining.length()>1) 
         recurring(res, remaining.substring(2, remaining.length()),remaining.substring(0,2),ipAddress, count+1);
       if(remaining.length()>2) 
         recurring(res, remaining.substring(3, remaining.length()),remaining.substring(0,3), ipAddress, count+1);
    }
}
