class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int maxAns = -1000000; 
        int currMax = 0;
        for(int i = 0 ;i < n ; i++){
            if(currMax > 0){
                currMax +=nums[i];
            }else{
                currMax = nums[i];
            }
            maxAns = max(maxAns , currMax);
        }
        return maxAns;
        
    }
};