class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<vector<int>,vector<string>> map;
        vector<vector<string>>ans;
        for(auto x : strs){
            vector<int> temp(26,0);
            for(char ch : x){
                temp[ch-'a']++;
            }
            map[temp].push_back(x);
        }
        for(auto [a,b] : map){
           ans.push_back(b);
        }
        return ans;
    }
};