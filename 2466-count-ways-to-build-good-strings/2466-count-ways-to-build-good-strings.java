
class Solution {
    
    int mod = 1000000007;
    Long[]dp;
    public int countGoodStrings(int low, int high, int zero, int one) {
        long ans=0;
        dp = new Long[high+1];
        for(int i = low  ; i <= high ; i++){
            ans+= calc(i , zero , one)%mod;
            ans%=mod;
        }
        return (int)ans;
    }
    
    
    public long calc(int range, int zero, int one){
        if(range<0)return 0L;
        if(range==0)return 1L;
        if(dp[range]!=null)return dp[range];
        long ans = 0;
        ans+= calc(range - zero , zero ,one)%mod;
        ans+= calc(range - one , zero , one)%mod;
        return dp[range] = ans;
    }
}