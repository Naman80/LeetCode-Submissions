class Solution {
     long mod=1000000007;
    long dp[][];
    public int countPaths(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        dp=new long[n][m];
        long ans=0;
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){

               ans=(ans+find(i,j,grid))%mod;
               ans=(ans+mod)%mod;
           }
       }
        return (int)(ans%1000000007);
    }
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
     long find(int i,int j,int grid[][]){

        if(dp[i][j]!=0) return dp[i][j];

        long ans=1;
        for(int k=0;k<4;k++){
            int i1=i+dir[k][0],j1=j+dir[k][1];

            if(i1<0 || j1<0 || i1==dp.length || j1==dp[0].length || grid[i][j]<=grid[i1][j1])
             continue;

            ans=(ans+find(i1,j1,grid))%mod;
        }
        ans=(ans+mod)%mod;
        return dp[i][j]=(ans);
    }
    }
    
    
    
    
//     static int solve(int r,int c,int[][] mat,int[][] dp){

//         if(dp[r][c] !=0) return dp[r][c];
//         int up = 1;
//         int right = 1;
//         int down = 1;
//         int left = 1;
//         if(r-1 >= 0){
//             if(mat[r-1][c] < mat[r][c])
//                 up = 1 + solve(r-1,c,mat,dp);
//         }
//         if(c+1 < mat[0].length ){
//             if(mat[r][c+1] < mat[r][c])
//                 right = 1 + solve(r,c+1,mat,dp);
//         }
//         if(r+1 < mat.length){
//             if(mat[r+1][c] < mat[r][c])
//                 down = 1 + solve(r+1,c,mat,dp);
//         }
//         if(c-1 >= 0){
//             if(mat[r][c-1] < mat[r][c])
//                 left = 1 + solve(r,c-1,mat,dp);
//         }
//         return dp[r][c] = Math.max(up,Math.max(right,Math.max(down,left)));
//     }
