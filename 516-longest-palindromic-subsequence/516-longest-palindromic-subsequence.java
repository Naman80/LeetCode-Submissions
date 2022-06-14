class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         String s2 = reverse(s);
//         int[][] dp = new int[n+1][n+1];
//         for(int i = 0 ; i < n+1;i++){
//             for(int j = 0 ;j< n+1 ;j++){
//                 if(i==0 || j ==0)continue;
//                 if(s.charAt(i-1) == s2.charAt(j-1)){
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }else{
//                     dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][n];
//     }
    
    public int longestPalindromeSubseq(String s) {
        // if (s == null || s.length() == 0) return 0;
        // if(s.length() == 1) return 1;
        // int n = s.length();
        // int[][] dp = new int[n + 2][n + 2];
        // for (int i = 1; i <= n; i++) {
        //     for (int j = n; j > 0; j--) {
        //         if (s.charAt(i - 1) == s.charAt(j - 1)) {
        //             dp[i][j] = dp[i - 1][j + 1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
        //         }
        //     }
        // }
        // return dp[s.length()][1];
        int n = s.length();
        Integer[][] dp = new Integer[n+1][n+1];
        return recursive(s,0,n-1,dp);
    }
    
    
    int recursive(String s ,int st , int e,Integer[][] dp){
        
        if(st==e)return 1;
        if(st>e)return 0;
        
        if(dp[st][e] != null)return dp[st][e];
        if(s.charAt(st) == s.charAt(e)){
            return dp[st][e] = 2 + recursive(s,st+1,e-1,dp);
        }else{
            return dp[st][e] = Math.max(recursive(s,st,e-1,dp),recursive(s,st+1,e,dp));
        }
    }
    
//     String reverse(String s){ 
//         String ans = "";
//         int i = s.length() -1;
//         while(i>=0){
//             ans+= s.charAt(i);
//             i--;
//         }
//         return ans;
//     }
}