class Solution {
public:
    
    int solve(int idx , int n , int k,vector<int>&nums, vector<int>& dp){
        
        if(idx>=n)return 0 ;
        if(dp[idx]!=-1)return dp[idx];
        int mx = -1;
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            if(idx+i < n){
                    mx = max(mx , nums[idx+i]);
            sum = max(sum , mx*(i+1) + solve(idx+i+1 , n , k , nums,dp));
            }
        }
        return dp[idx] = sum;
        
        
    }
    
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n , -1);
        
        return solve(0 , n , k , arr , dp);
    }
};