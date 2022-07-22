class Solution {
    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        int n = sat.length;
        int[][] dp = new int[n+1][n+2];
        // return solve(0,1,sat,dp);   
        
        
        for(int idx = n-1 ; idx >=0 ; idx--){
            for(int time = n ; time >=1 ; time--){
                int pick = (sat[idx] * time) + dp[idx+1][time+1];
                int np = dp[idx+1][time];
                dp[idx][time] = Math.max(np,pick);
            }
        }
        
        return dp[0][1];
    }
    // int solve(int idx , int time , int[] sat,Integer[][] dp){
    //     if(idx >= sat.length){
    //         return 0;
    //     }
    //     if(dp[idx][time]!=null)return dp[idx][time];
    //     int pick = (sat[idx] * time) + solve(idx+1 , time+1 , sat,dp);
    //     int np = solve(idx+1,time,sat,dp);
    //     return dp[idx][time] = Math.max(np,pick);
    // }
}