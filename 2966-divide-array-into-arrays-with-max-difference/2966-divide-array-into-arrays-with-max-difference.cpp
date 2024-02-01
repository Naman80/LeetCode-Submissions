class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<vector<int>> ans(n/3);
        sort(nums.begin() , nums.end());
        for(int i = 0 ; i < n/3 ; i++)
            for(int j = i*3 ; j < i*3+3 ; j++)
                ans[i].push_back(nums[j]);        
        for(auto x : ans)if(x[2] - x[0] > k)return {};
        return ans;
    }
};