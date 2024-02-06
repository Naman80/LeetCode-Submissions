class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<vector<int>,vector<string>> map;
        
        for(auto x : strs){
            vector<int> temp(26,0);
            for(char ch : x){
                temp[ch-'a']++;
            }
            bool mapcheck = true;
            for(auto &[a,b] : map){
                bool check =true;
                for(int i = 0 ; i < 26 ; i++){
                    if(a[i] != temp[i]){
                        check = false;
                        break;
                    }
                }
                if(check){
                    b.push_back(x);
                    mapcheck = false;
                    break;
                }
            }
            if(mapcheck){
                map[temp] = {x};
            }    
        }
        vector<vector<string>>ans;
        for(auto [a,b] : map){
           ans.push_back(b);
        }
        return ans;
    }
};