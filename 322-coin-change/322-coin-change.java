class Solution {
    public int coinChange(int[] coins, int amt) {
        if(amt==0)return 0;
        int n = coins.length;
        int[] dp = new int[amt+1]; 
        dp[0] = 1;
        
        for(int i = 1;i<amt+1;i++){
            int max = Integer.MAX_VALUE;
            for(int j = 0;j<n;j++){
                if(i - coins[j] >=0 && dp[i-coins[j]]!=0){
                    max = Math.min(dp[i-coins[j]]+1,max); 
                }
            }
            
            if(max==Integer.MAX_VALUE)dp[i] = 0;
            else dp[i] = max;
        }
        
        
        return dp[amt]-1;
        
    }
}