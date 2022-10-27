class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        int ans=solve(0 , nums, dp);
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
    public int solve(int idx , int[] nums, Integer[] dp){
        if(idx>= nums.length)return Integer.MAX_VALUE;
        if(idx == nums.length - 1)return 0;
        if(dp[idx]!=null)return dp[idx];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx] ; i++){
            ans = Math.min(ans , solve(idx+i , nums,dp));
        }
        if(ans == Integer.MAX_VALUE)return dp[idx] = ans;
        return dp[idx] = ans+1;
    }
    
    
    
}