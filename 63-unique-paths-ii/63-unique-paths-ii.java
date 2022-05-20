class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
       
        int m = mat.length;
        int n = mat[0].length;
        // int[][] dp = new int[m][n];
        // for(int[] x:dp)Arrays.fill(x,-1);
        // return solve(0,0,mat,dp);
         if(mat[0][0]==1 || mat[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i = m-2;i>=0;i--){
            if(mat[i][n-1]==0 && dp[i+1][n-1]!=0)dp[i][n-1] = 1;
        }
        for(int i = n-2;i>=0;i--){
             if(mat[m-1][i]==0 && dp[m-1][i+1]!=0)dp[m-1][i] = 1;
        }
         
        for(int i = m-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                if(mat[i][j] != 1) dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    
//     static int solve(int r,int c,int[][] mat,int[][] dp){
        
//         if(mat[r][c]==1)return 0;
//         if(dp[r][c] != -1)return dp[r][c];
//         if(r==mat.length-1 && c ==  mat[0].length-1)return 1;
//         int down = 0;int right = 0;
//         if(r+1 < mat.length ){
//             down = solve(r+1,c,mat,dp);
//         }
//         if(c+1 <mat[0].length){
//             right = solve(r,c+1,mat,dp);
//         }
//         return dp[r][c] = down+right;        
//     }
}