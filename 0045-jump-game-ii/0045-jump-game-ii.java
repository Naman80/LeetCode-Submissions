class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return solve(0 , nums,dp);
    }
    
    
    int solve(int idx , int[] nums,Integer[] dp){
        
        if(idx>=nums.length)return Integer.MAX_VALUE;
        
        if(idx == nums.length - 1)return 0;
        if(dp[idx]!=null)return dp[idx];
        int ans =  Integer.MAX_VALUE ;
        
        for(int i = 1 ; i <= nums[idx] ; i++){ 
           int temp =  solve(idx+i , nums,dp);
           ans = Math.min(ans , temp);
            
        }
        
        if(ans == Integer.MAX_VALUE)return dp[idx] = ans;
        
        return dp[idx] = ans+1;
        
        
    }
}