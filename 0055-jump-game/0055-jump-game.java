class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        if(nums[0] == 0)return false;
        Boolean[] dp = new Boolean[n];
        return solve(0 , nums,dp);
    }
    
    
    boolean solve(int idx , int[] nums,Boolean[] dp){
        
        if(idx == nums.length - 1)return true;
        if(idx>=nums.length)return false;
        if(dp[idx]!=null)return dp[idx];
        for(int i = 1 ; i <= nums[idx] ; i++){
            if(solve(idx+i , nums,dp))return dp[idx] = true;
        }
        return dp[idx] = false;
    }
    
}