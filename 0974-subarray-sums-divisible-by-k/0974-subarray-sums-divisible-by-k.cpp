class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        int n = nums.size();
        map<int , int > map;
        int ans = 0;
        map[0]=1;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+=nums[i];
            int mod = sum%k;
            if(mod<0)mod+=k;
            ans+=map[mod];
            map[mod]++;
        }
        return ans;
        
    }
};