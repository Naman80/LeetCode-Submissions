class Solution {
     public  static int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int ans = solve(i,j,matrix,dp);
                max = Math.max(max,ans);
            }
        }
        return max;
    }
    static int solve(int r,int c,int[][] mat,int[][] dp){

        if(dp[r][c] !=0) return dp[r][c];
        int up = 1;
        int right = 1;
        int down = 1;
        int left = 1;
        if(r-1 >= 0){
            if(mat[r-1][c] < mat[r][c])
                up = 1 + solve(r-1,c,mat,dp);
        }
        if(c+1 < mat[0].length ){
            if(mat[r][c+1] < mat[r][c])
                right = 1 + solve(r,c+1,mat,dp);
        }
        if(r+1 < mat.length){
            if(mat[r+1][c] < mat[r][c])
                down = 1 + solve(r+1,c,mat,dp);
        }
        if(c-1 >= 0){
            if(mat[r][c-1] < mat[r][c])
                left = 1 + solve(r,c-1,mat,dp);
        }
        return dp[r][c] = Math.max(up,Math.max(right,Math.max(down,left)));
    }
}