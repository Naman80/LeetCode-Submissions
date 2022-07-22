class Solution {
    public int maxSatisfaction(int[] sat) {
        
        Arrays.sort(sat);
        int n = sat.length;
        Integer[][] dp = new Integer[n+1][n+2];
        return solve(0,1,sat,dp);
        
    }
    
    
    
    int solve(int idx , int time , int[] sat,Integer[][] dp){
        
        if(idx >= sat.length){
            return 0;
        }
        if(dp[idx][time]!=null)return dp[idx][time];
        int pick = (sat[idx] * time) + solve(idx+1 , time+1 , sat,dp);
        
        int np = solve(idx+1,time,sat,dp);
        
        
        return dp[idx][time] = Math.max(np,pick);
        
    }
}