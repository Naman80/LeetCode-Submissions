class Solution {
    public int integerBreak(int n) {
        // int[][] dp = new int[n+1][n+1];
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for(int i = 2 ; i < n+1;i++){
            int max = 0;
            for(int j = 1 ; j < n + 1 ; j++){
                
                if(j>i)continue;
                
                max = Math.max(max, Math.max( j * (i - j) ,  j * dp[i-j] ) );
                
                
            }
            dp[i] = max;
            
        }
        
        return dp[n];
        
        
        
        
//         for(int i = 1;i<n+1;i++){
//             for(int j = 1 ; j < n+1;j++){
//                 if(j<=i){
//                     dp[i][j] = dp[i-1][j];
//                 }else{
//                     dp[i][j] = Math.max(Math.max(i*(j-i) , i * (dp[i][j-i])),dp[i-1][j]);
//                 }
                
//                 System.out.print(dp[i][j] + "   ");
//             }
//             System.out.println();
//         }
        
        // return dp[n][n];
        
    }
}