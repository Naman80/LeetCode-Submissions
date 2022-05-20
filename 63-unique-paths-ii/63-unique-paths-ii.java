class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
       
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int[] x:dp)Arrays.fill(x,-1);
        return solve(0,0,mat,new boolean[m][n],dp);
//          if(mat[0][0]==1 || mat[m-1][n-1]==1) return 0;
//         int[][] dp = new int[m][n];
//         for(int i = 0;i<m;i++){
//             if(!(mat[i][n-1]==1))dp[i][n-1] = 1;
//         }
//         for(int i = 0;i<n;i++){
//             if(!(mat[m-1][i]==1))dp[m-1][i]=1;
//         }
        
//         for(int i = m-2;i>=0;i--){
//             for(int j = n-2;j>=0;j--){
//                 if(mat[i][j] != 1) dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }
        
//         return dp[0][0];
    }
    
    static int solve(int r,int c,int[][] mat,boolean[][] visit,int[][] dp){
        
        if(mat[r][c]==1)return 0;
        if(dp[r][c] != -1)return dp[r][c];
        if(r==mat.length-1 && c ==  mat[0].length-1)return 1;
        int down = 0;int right = 0;
        visit[r][c] = true;
        if(r+1 < mat.length && !visit[r+1][c]){
            down = solve(r+1,c,mat,visit,dp);
        }
        if(c+1 <mat[0].length && !visit[r][c+1]){
            right = solve(r,c+1,mat,visit,dp);
        }
        visit[r][c] = false;
        return dp[r][c] = down+right;        
    }
}