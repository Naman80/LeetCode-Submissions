class Solution {
public:
    int countSubstrings(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n+1 , vector<int>(n+1,0));
        int ans = 0;
        for(int g = 0 ; g < n ;g++){
            for(int i = 0 , j = g ;j < n ; j++ , i++){
                if(i==j){
                    dp[i][j] = 1;
                    ans++;
                }else if(g==1){
                    if(s[i] == s[j]){
                        dp[i][j] = 1;
                        ans++;
                    }
                }else{
                    if(s[i]==s[j]){
                        if(dp[i+1][j-1]){dp[i][j] = 1;ans++;}
                    }
                }
            }
        }
        return ans;
        
    }
};