class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin() , nums.end());
        vector<int> ans;
        vector<pair<int,int>> dp(n);
        int last = INT_MIN;
        int fidx = 0;
        for(int i=0;i<n;i++){
            int mx = 0;
            int idx = i;
            for(int j = 0 ; j < i ; j++){
                if(nums[j]%nums[i] == 0 || nums[i] % nums[j]==0){
                    if(mx < dp[j].first){
                        mx = dp[j].first;
                        idx = j;
                    }
                }
            }
            dp[i] = {mx+1 , idx};
            if(last < dp[i].first){
                last = dp[i].first;
                fidx = i;
            }
        }        
        while(true){
            ans.push_back(nums[fidx]);
            if(dp[fidx].second == fidx)break;
            fidx = dp[fidx].second;
            
        }
        return ans;
        
        
        
    }
};