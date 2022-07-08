class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        
        for(int x : nums){
            sum+=x;
        }
        
        Integer[][] dp = new Integer[nums.length + 1][(2 * sum) + 1];
        
        
        
        return solve(0,0,nums,target,sum,dp);
        
        
        
    }
    
    
    
    int solve(int idx , int sum , int[] nums,int target , int tot,Integer[][] dp){
        
        if(idx == nums.length){
            if(sum==target)return 1;
            else return 0;
        }
        if(dp[idx][sum + tot] != null)return dp[idx][sum+tot];
        
        int neg = solve(idx+1,sum-nums[idx],nums,target,tot,dp);
        
        int pos = solve(idx+1,sum+nums[idx],nums,target,tot,dp);
        
        return dp[idx][sum + tot] = neg + pos;
        
        
        
        
    }
    
    
    
}