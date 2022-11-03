class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        int size = nums.size();
        // vector<int> ans;
        
        map<int,int> mapi;
        for(int i = 0 ; i < size ; i++){
            mapi[nums[i]] = i;
        }
        for(int i =0  ; i < size ;  i ++){
            
            int remain = target - nums[i];
            
            if(mapi.find(remain) != mapi.end()){
                
                if(i!= mapi[remain])return {i , mapi[remain]};
                
            }
            
        }
        return {-1 ,-1};
    }
};