class Solution {
public:
    int minSteps(string s, string t) {
        int ans = 0;
        map<char,int> smap;
        map<char,int> tmap;
        for(char ch : s)smap[ch]++;
        for(char ch : t)tmap[ch]++;
        for(auto [a,b] : tmap){
            if(b > smap[a])ans+= b-smap[a];
        }
        return ans;
    }
};