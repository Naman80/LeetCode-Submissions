class Solution {
    public int integerBreak(int n) {
        int[][] dp = new int[n+1][n+1];
        
        
        for(int i = 1;i<n+1;i++){
            for(int j = 1 ; j < n+1;j++){
                if(j<=i){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(Math.max(i*(j-i) , i * (dp[i][j-i])),dp[i-1][j]);
                }
                
                // System.out.print(dp[i][j] + "   ");
            }
            // System.out.println();
        }
        
        return dp[n][n];
        
    }
}