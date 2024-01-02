class Solution {
public:
    vector<vector<int>> findMatrix(vector<int>& nums) {
        int n = nums.size();
        vector<int>map(n+1, 0);
        int mx = -1;
        int mxe = -1;
        for(int i = 0 ; i < n ; i++){
            map[nums[i]]++;
            mx = max(mx , map[nums[i]]);
            mxe = max(mxe , nums[i]);
        }
        vector<vector<int>> ans(mx);
        for(int i = 1 ; i <= mxe ; i++ ){
            for(int j = 0 ; j < map[i] ; j++){
                ans[j].push_back(i);
            }
        }
        
        return ans;
        
    }
};