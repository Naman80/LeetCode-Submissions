class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        int n = nums.size();
        vector<int>map(n+1, 0);
        vector<vector<int>> ans;           
        for(int i = 0 ; i < n ; i++){   
            map[nums[i]]++;
            if(ans.size()<map[nums[i]]){
                ans.push_back({});
            }
            ans[map[nums[i]]-1].push_back(nums[i]);
        }
        return ans;
        // tc -> O(n) + O(max_ele * most_freq_ele)
    }
};