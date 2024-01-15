class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        map<int,  int> wins;
        map<int,int > loss;
        set<int> all;
        for(auto  x : matches){
            wins[x[0]]++;
            loss[x[1]]++;
            all.insert(x[0]);
            all.insert(x[1]);
            
        }
        vector<int> a0;
        vector<int> a1;
        for(int x : all){
            if(loss[x]==0)a0.push_back(x);
            if(loss[x]==1)a1.push_back(x);
        }
        vector<vector<int>> ans;
        ans.push_back(a0);
        ans.push_back(a1);
        return ans;
        
    }
};