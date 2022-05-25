class Solution {
public:
     int solve(vector<int>&nums, int i, int prev, vector<vector<int>>&dp){
        if(i>=nums.size()){
            return 0;
        }
       
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int pick = 0;
        if(prev==-1 || nums[i]>nums[prev]){
            pick = 1 + solve(nums,i+1,i,dp);
        }
        int nonPick = solve(nums,i+1,prev,dp);
        dp[i][prev+1] = max(pick,nonPick);
        return dp[i][prev+1];
    }
   
    int lengthOfLIS(vector<int>&nums){
        int i = 0;
        int prev = -1;
        vector<vector<int>>dp(nums.size()+1,vector<int>(nums.size()+1,-1));
        int ans = solve(nums,i,prev,dp);
        return ans;
    }
};