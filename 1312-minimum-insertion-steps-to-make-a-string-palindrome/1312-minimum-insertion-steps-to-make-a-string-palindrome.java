class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n+1][n+1];
        return solve(s,0,n-1,dp);
    }
    
    int solve(String s , int st , int e,Integer[][] dp){
        if(st>=e)return 0;
        if(dp[st][e] != null) return dp[st][e];
        if(s.charAt(st) != s.charAt(e)){
            return dp[st][e] = 1 + Math.min(solve(s,st+1,e,dp),solve(s,st,e-1,dp));
            
        }else{
            return dp[st][e] =  solve(s,st+1,e-1,dp);
        }
    }
}