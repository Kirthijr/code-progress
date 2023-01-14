/* Given an m x n matrix, return all elements of the matrix in spiral order.
  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res= new ArrayList<>();
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        int dir = 0, r=0, c=0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m*n;i++){
            visited[r][c] = true;
            res.add(matrix[r][c]);
            int r1 = r + dr[dir];
            int c1 = c + dc[dir];
            if(r1 >= 0 && r1 < m && c1 >=0 && c1 <n && !visited[r1][c1]){
                r = r1;
                c = c1;
            }else{
                dir = (dir+1)%4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return res;
    }
}
