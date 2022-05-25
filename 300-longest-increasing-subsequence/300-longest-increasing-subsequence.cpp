class Solution {
public:
    int f(int idx, int prev_idx, int n, vector<vector<int>>&dp, vector<int>&nums){
        if(idx==n){
            return 0;
        }
        if(dp[idx][prev_idx+1]!=-1){
            return dp[idx][prev_idx+1];
        }
        int not_take=0+f(idx+1,prev_idx,n,dp,nums);
        int take=INT_MIN;
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            take=1+f(idx+1,idx,n,dp,nums);
        }
        return dp[idx][prev_idx+1]=max(take,not_take);
    }
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<vector<int>>dp(n+1,vector<int>(n+1,-1));
        return f(0,-1,n,dp,nums);
    }
};