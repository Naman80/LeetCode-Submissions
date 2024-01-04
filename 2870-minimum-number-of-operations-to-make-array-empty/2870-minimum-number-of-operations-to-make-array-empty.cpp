class Solution {
public:
    int minOperations(vector<int>& nums) {
      int ans = 0;
        int n =  nums.size();
        map<int  , int > map;
        for(int x : nums) map[x]++;    
        for(auto [a,b] : map){
            if(b==1)return -1;
            int rem = b%3;
            if(rem == 0){
                ans+= (b/3);
            }else if(rem == 1){
                int temp = b/3;
                int cal = b - (temp-1)*3;
                ans+=(cal/2) + (temp-1);
            }else{
                int temp = b/3;
                int cal = b - (temp)*3;
                ans+=(cal/2) + (temp);
            }
        }
        return ans;
    }
};