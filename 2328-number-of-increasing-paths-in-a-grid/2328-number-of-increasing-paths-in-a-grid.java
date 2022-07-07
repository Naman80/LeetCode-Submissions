class Solution {
      long mod=1000000007;
    public int countPaths(int[][] matrix) {
        
//         int n=grid.length,m=grid[0].length;
//         dp=new long[n][m];
//         long ans=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){

//                ans=(ans+find(i,j,grid))%mod;
//                ans=(ans+mod)%mod;
//            }
//        }
//         return (int)(ans%1000000007);
//     }
//     int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
//      long find(int i,int j,int grid[][]){

//         if(dp[i][j]!=0) return dp[i][j];

//         long ans=1;
//         for(int k=0;k<4;k++){
//             int i1=i+dir[k][0],j1=j+dir[k][1];

//             if(i1<0 || j1<0 || i1==dp.length || j1==dp[0].length || grid[i][j]<=grid[i1][j1])
//              continue;

//             ans=(ans+find(i1,j1,grid))%mod;
//         }
//         ans=(ans+mod)%mod;
//         return dp[i][j]=(ans);
//         }
//     }
        
        long[][] dp = new long[matrix.length][matrix[0].length];
           for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = -1;
            }}
        
        long max = matrix.length * matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                
                max = (max%mod + solve(i,j,matrix,dp)%mod)%mod;
            }
        }
        return (int)max;
        
        
    }
     long solve(int r,int c,int[][] mat,long[][] dp){

        if(dp[r][c] != -1) return dp[r][c];
        long up = 0;
        long right = 0;
        long down = 0;
        long left = 0;
        if(r-1 >= 0){
            if(mat[r-1][c] < mat[r][c])
                up = 1 + solve(r-1,c,mat,dp)%mod;
        }
        if(c+1 < mat[0].length ){
            if(mat[r][c+1] < mat[r][c])
                right = 1 + solve(r,c+1,mat,dp)%mod;
        }
        if(r+1 < mat.length){
            if(mat[r+1][c] < mat[r][c])
                down = 1+ solve(r+1,c,mat,dp)%mod;
        }
        if(c-1 >= 0){
            if(mat[r][c-1] < mat[r][c])
                left = 1+ solve(r,c-1,mat,dp)%mod;
        }
        return dp[r][c] = (((up + right)%mod + down)%mod + left)%mod;
    }
}
