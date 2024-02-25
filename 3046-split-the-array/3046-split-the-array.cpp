class Solution {
public:
    bool isPossibleToSplit(vector<int>& nums) {
        int n = nums.size();
        map<int,int>map;
        for(int x :nums)map[x]++;
        for(auto&[a,b]:map)if(b>=3)return false;
        return true;
    }
};