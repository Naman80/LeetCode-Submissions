class Solution {
public:
    int numSquares(int n) {
        vector<int>perf;
        for(int i = 1 ; i*i < 10001; i++){
            perf.push_back(i*i);
        }
        vector<int> dp(n+1 , 0);
        dp[1]=1;
        for(int i = 2; i <= n ;i++){
            int idx = lower_bound(perf.begin() , perf.end() , i) - perf.begin();
            // cout << idx ;
            int low = perf[idx] == i ? idx : idx-1;
            int mn = INT_MAX;
            for(int j = 0 ; j <= low ; j++){
                mn = min(mn , dp[i - perf[j]]);
            }
            dp[i] = mn+1;
        }
        return dp[n];
    }
};