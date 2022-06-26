class Solution {
    public int maximumScore(int[] nums, int[] mul) {
        int n = nums.length;
        int m = mul.length;
//         int s = 0;
// //         for(int i = 0 ;i<n;i++){
// //             for(int  j = 0;j<m;j++){
               
// //             }
// //         }
        
        
        
//         return s;
        Integer[][] dp = new Integer[n+1][m+1];
        return solve(0,n-1,nums,mul,0,dp);
    }
    
    
    int solve(int i ,int j , int[] nums,int[] mul,int m,Integer[][] dp){
    
        if(m == mul.length)return 0;
        if(dp[i][m]!=null)return dp[i][m];
        int fp = (nums[i] * mul[m]) + solve(i+1,j,nums,mul,m+1,dp);
        int bp = (nums[j] * mul[m]) + solve(i,j-1,nums,mul,m+1,dp);
        return dp[i][m] = Math.max(fp,bp);
    }
    
}