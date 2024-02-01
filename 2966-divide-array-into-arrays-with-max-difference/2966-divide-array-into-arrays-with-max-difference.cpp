class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        vector<vector<int>> ans;
        vector<vector<int>> ans1;
        sort(nums.begin() , nums.end());
        int n = nums.size();
        for(int i = 0 ; i < n/3 ; i++){
            vector<int>temp;
                for(int j = i*3 ; j < i*3+3 ; j++){
                temp.push_back(nums[j]);        
                }
            ans.push_back(temp);
        }
        for(auto x : ans){
            if(x[2] - x[0] > k)return ans1;
        }
        return ans;
    }
};