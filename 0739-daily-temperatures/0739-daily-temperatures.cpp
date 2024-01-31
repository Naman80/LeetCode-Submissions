class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {
        int n = temp.size();
        vector<int> ans(n,0);
        stack<pair<int,int>> st;
        int i = n-1;
        while(i>=0){
            while(st.size()>0 && temp[i] >= st.top().first)st.pop();
            if(st.size()==0)ans[i] = 0;
            else ans[i] = st.top().second - i;
            st.push({temp[i] , i});
            i--;
        }        
        return ans;
    }
};