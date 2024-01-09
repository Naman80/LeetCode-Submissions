class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        map<int,int> map;
        vector<int>ans;
        priority_queue<int> pq;
        int i  = 0 ;
        for(i= 0 ; i < k  ; i++){
            map[nums[i]]++;
            pq.push(nums[i]);
        }        
        ans.push_back(pq.top());
        while(i < n ){
            map[nums[i]]++;
            map[nums[i-k]]--;
            pq.push(nums[i]);
            while(map[pq.top()]==0){
                pq.pop();
            }
            ans.push_back(pq.top());
            i++;
        }
        return ans;
    }
};