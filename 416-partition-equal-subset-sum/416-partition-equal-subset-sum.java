class Solution {
    public boolean canPartition(int[] arr) {
         int sum = 0;
        for(int x:arr){
            sum+=x;
        }
        if(sum%2!=0)return false;
        int k = sum/2;
        int n = arr.length;
        boolean[] dp = new boolean[k+1];
        dp[0] = true;
        
        for(int i = 0 ; i<n;i++){
            for(int j = k;j>=1;j--){
                if(arr[i]>j){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] || dp[j - arr[i]];
                }
            }
        }
        
        return dp[k];
        
        
        
        // Boolean[][] dp = new Boolean[arr.length+1][(sum/2)+1];
        // return solve(0,arr,0,sum/2,dp);
    }
    // boolean solve(int idx,int[] nums,int csum,int sum,Boolean[][] dp){
    //     if(csum>sum)return false;
    //     if(csum==sum)return true;
    //     if(idx>=nums.length)return false;
    //     if(dp[idx][csum]!=null)return dp[idx][csum];
    //     boolean opt1 = solve(idx+1,nums,csum,sum,dp);
    //     boolean opt2 = solve(idx+1,nums,csum+nums[idx],sum,dp);
    //     return dp[idx][csum] = opt1||opt2;
    // }
}