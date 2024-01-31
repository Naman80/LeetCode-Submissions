class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        map<long long , int> map[n+1];
        int ans = 0;
        for(int i= 1 ; i < n ;  i ++){
            for(int j = 0 ; j < i; j ++){
                long long diff = nums[i]* 1LL - nums[j];
                int count = map[j][diff];
                ans+=count;
                map[i][diff] = count+map[i][diff]+1;
            }
        }
        return ans;
    }
};