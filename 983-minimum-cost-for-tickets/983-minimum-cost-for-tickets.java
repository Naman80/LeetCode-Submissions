class Solution {
    int[] days,costs;
    int[][] dp;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        int n = days.length;
        dp = new int[n][days[n-1]+30];
        for(int[] x:dp)Arrays.fill(x,-1);
        return solve(0,0);
    }
    
    
     int solve(int idx ,int next){
        if(idx>=days.length)return 0;
        if(dp[idx][next]!=-1)return dp[idx][next];
        if(days[idx]>next){
             int cal = Integer.MAX_VALUE;               
                    cal = Math.min(costs[0] + solve(idx+1,days[idx]),cal);
                    cal = Math.min(costs[1] + solve(idx+1,days[idx]+6),cal);
                    cal = Math.min(costs[2] + solve(idx+1,days[idx]+29),cal);
            return dp[idx][next] = cal;
        } 
        return dp[idx][next] =  solve(idx+1,next);
        
        
        
    }
}