class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        set<int>set;
        vector<int>ans;
        for(int x:nums){
            if(set.find(x)!=set.end())ans.push_back(x);
            set.insert(x);
        }
        int n = nums.size();
        for(int i = 0 ; i < n ; i ++)if(set.find(i+1)==set.end()){ans.push_back(i+1);break;}
        return ans;
    }
};