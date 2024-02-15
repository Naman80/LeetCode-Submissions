class Solution {
public:
    long long largestPerimeter(vector<int>& nums) {
        long long ans = 0;
        long long sum = 0;
        sort(nums.begin() , nums.end());
        int n = nums.size();
        for(int i =  0 ; i < n ; i++){
          sum+=nums[i];
        }
        for(int i = n -1 ; i >=0 ; i--){
            if(sum-nums[i] > nums[i]){
                break;
            }else{
                sum-=nums[i];
            }
        }
        return sum!=0?sum : -1;
    }
};