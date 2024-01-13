class Solution {
public:
    bool closeStrings(string word1, string word2) {
       map<int ,int>grp1;
       map<int ,int>grp2;
       int map1[26] = {0}; 
       int map2[26] = {0};
        for(char ch : word1)map1[ch-'a']++;
        for(char ch : word2){
            map2[ch-'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(map1[i]==0 && map2[i]>0)return false;
            if(map2[i]==0 && map1[i]>0)return false;
            grp1[map1[i]]++;
            grp2[map2[i]]++;
        }
        for(auto [a,b]: grp1){
            if(b != grp2[a])return false;
        }
        return true;
    }
};