/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int[] drow = new int[]{0,1,0,-1};
        int[] dcol = new int[]{1,0,-1,0};
        int dr=0,dc=0,dir=0, a, b, count = 1;
        for(int i=0;i<n*n;i++){
            res[dr][dc] = count++;
            a = dr + drow[dir];
            b = dc + dcol[dir];
            if(a>=0 && a<n && b>=0 && b<n && res[a][b] == 0){
                dr = a;
                dc = b;
            }else{
                dir = (dir+1)%4;
                dr += drow[dir];
                dc += dcol[dir];
            }
        }
        return res;
    }
}
