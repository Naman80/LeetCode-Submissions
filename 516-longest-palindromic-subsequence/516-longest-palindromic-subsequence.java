class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = reverse(s);
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 0 ; i < n+1;i++){
            for(int j = 0 ;j< n+1 ;j++){
                if(i==0 || j ==0)continue;
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[n][n];
        
    }
    
    String reverse(String s){
        
        String ans = "";
        
        int i = s.length() -1;
        
        while(i>=0){
            ans+= s.charAt(i);
            i--;
        }
        
        return ans;
        
    }
}