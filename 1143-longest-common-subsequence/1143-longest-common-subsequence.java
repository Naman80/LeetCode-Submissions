class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0 ; i < n+1;i++){
            for(int j = 0 ; j < m+1 ;j++){
                if(i==0 || j ==0)continue;
                
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
        //SPACE OPTIMISED TABULATION CODE
        
        // int[] dp = new int[m+1];
        // for(int i = 1;i<n+1;i++){
        //     int[] temp = new int[m+1];
        //     for(int j = 1;j<m+1;j++){
        //         if(t1.charAt(i-1) == t2.charAt(j-1)){
        //             temp[j] = 1 + dp[j-1];
        //         }else{
        //             temp[j] = Math.max(temp[j-1],dp[j]);
        //         }
        //     }
        //     dp = temp;
        // }
        // return dp[m];
        // int[][] dp = new int[n+1][m+1];
        // for(int[] x : dp){
        //     Arrays.fill(x,-1);
        // }
        // return solve(t1,t2 , dp);
    }
    
    //USING RECURSION + MEMO
//     int solve(String s1, String s2 ,int[][] dp){
//         int n = s1.length();
//         int m = s2.length();
        
//         if(dp[n][m] != -1) return dp[n][m];
//         if(n==0 || m== 0)return 0;
//         if(s1.charAt(n-1) == s2.charAt(m-1)){
//             return dp[n][m] = 1 + solve(s1.substring(0,n-1) , s2.substring(0,m-1) ,dp);
//         }else{
//             return dp[n][m] = Math.max(solve(s1.substring(0,n-1) , s2.substring(0,m),dp),   solve(s1.substring(0,n) , s2.substring(0,m-1),dp));
//         }
//     }
}