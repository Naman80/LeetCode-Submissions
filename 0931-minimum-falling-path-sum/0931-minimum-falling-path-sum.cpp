class Solution {
public:
    int solve(int r, int c , int n, vector<vector<int>>& matrix , vector<vector<int>>& dp){
        if(r < 0 || r >=n || c< 0 || c >= n)return INT_MAX;
        if(dp[r][c]!=INT_MAX)return dp[r][c]; 
        int mini = INT_MAX ;
        mini = min(mini ,  solve(r+1 , c-1, n , matrix ,dp));
        mini = min(mini ,  solve(r+1 , c, n , matrix ,dp));
        mini = min(mini ,  solve(r+1 , c+1, n , matrix ,dp));
        if(mini == INT_MAX)return dp[r][c] = matrix[r][c];
        return dp[r][c] = mini+matrix[r][c];
        
        
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        int mini = INT_MAX;
        int n = matrix.size();
        vector<vector<int>> dp(n , vector<int>(n , INT_MAX));
        for(int i = 0 ; i < n ; i++){
            mini = min(mini , solve(0 , i , n , matrix ,dp));
        }
        return mini;
    }
};