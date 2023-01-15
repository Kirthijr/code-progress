/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/
public class Solution {
    public int climbStairs(int n) {
        int mem[] = new int[n+1];
        return climb_Stairs(n, mem);
    }
    public int climb_Stairs(int n, int[] mem) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if(mem[n] > 0)
            return mem[n];
        
        mem[n] =  climb_Stairs(n-1, mem) + climb_Stairs(n-2, mem);
        return mem[n];
    }
}
