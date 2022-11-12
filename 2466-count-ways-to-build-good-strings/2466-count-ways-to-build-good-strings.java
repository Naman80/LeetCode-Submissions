
class Solution {
    
    int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        
        long[] dp  = new long[high+1];
        
        dp[0] = 1L;
        
        for(int i = 1 ; i < high+1; i++){
            if(zero<=i){
                dp[i]+= dp[i - zero]%mod;
            }
            
            if(one<=i){
                dp[i]+=dp[i - one]%mod;
            }
        }
            long ans = 0;
        for(int i = low ; i <= high ; i++){
            ans+= dp[i]%mod;
            ans%=mod;
        }
        
        return (int)ans;
        
    }
    
 
    
    
}