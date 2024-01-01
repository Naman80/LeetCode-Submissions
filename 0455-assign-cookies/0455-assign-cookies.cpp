class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int n = s.size();
        int j = 0 ;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(s[i] >= g[j]){
                ans ++;
                j++;
            }
            if(j>= g.size())break;
        }

        return ans;
    }
};