class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
//         int dp[n];
//         dp[0] = 1;
//         int ans = 1;
//         for(int i = 1 ; i < n ; i++){
//             int temp = 0;
//             for(int j = 0 ; j < i ; j++){
//                 if(nums[j] < nums[i])temp=max(temp , dp[j]);
//             }
//             dp[i] = temp+1;
//             ans = max(ans , dp[i]);
//         }
        
//         return ans;
        
        vector<int> list;
        list.push_back(nums[0]);
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > list[list.size()-1]){
                list.push_back(nums[i]);
            }else{
                auto find = lower_bound(list.begin() , list.end() , nums[i]);
                int idx = find - list.begin();
                list[idx] = nums[i];
            }
        }
        return list.size();
    }
};