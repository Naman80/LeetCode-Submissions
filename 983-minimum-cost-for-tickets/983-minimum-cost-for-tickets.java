class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[][] dp = new int[n][days[n-1]+30];
        for(int[] x:dp)Arrays.fill(x,-1);
        return solve(0,0,days,costs,dp);
    }
    
    
    static int solve(int idx ,int next ,int[] days,int[] cost,int[][] dp){
        if(idx>=days.length)return 0;
        if(dp[idx][next]!=-1)return dp[idx][next];
        if(days[idx]>next){
             int cal = Integer.MAX_VALUE;
            for(int i = 0;i<3;i++){
               
                if(i==0){
                    cal = Math.min(cost[i] + solve(idx+1,days[idx],days,cost,dp),cal);
                } 
                else if(i==1){
                    cal = Math.min(cost[i] + solve(idx+1,days[idx]+6,days,cost,dp),cal);
                }else{
                    cal = Math.min(cost[i] + solve(idx+1,days[idx]+29,days,cost,dp),cal);
                }
                
                
            }
            return dp[idx][next] = cal;
        } 
        
        return dp[idx][next] =  solve(idx+1,next,days,cost,dp);
        
        
        
    }
}