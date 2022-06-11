class Solution {
    public int maxProfit(int[] prices){
        
        int ans = 0;
        int n  = prices.length;
        for(int i = 1 ;i<n;i++){
            if(prices[i-1] < prices[i]){
                ans+= prices[i] - prices[i-1];
            }
        }
        
        return ans;
        
    }
    
    // public int maxProfit(int[] prices) {
    //     long[][] dp = new long[prices.length+1][10001];
    //     for(long[] x :dp)Arrays.fill(x,-1);
    //     return (int)help(0,prices[0],prices,dp);
    // }
    // public long help(int idx, int min,int[] prices,long[][] dp){
    //     if(idx>=prices.length)return 0;
    //     if(dp[idx][min]!= -1)return dp[idx][min];
    //     long buy = help(idx+1,Math.min(min,prices[idx]),prices,dp);
    //     long sell = (prices[idx] - min) + help(idx+1,prices[idx],prices,dp);
    //     return dp[idx][min] = Math.max(buy,sell);
    // }
}