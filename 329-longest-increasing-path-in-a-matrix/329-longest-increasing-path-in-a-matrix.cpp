class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
      int ans = 0;
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>>dp(row,vector<int>(col,-1));
       
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               int temp = solve(row,col,i,j,matrix,dp);
                ans = max(ans,temp);
            }
        }
       
        return ans;
    }
    
    
    int solve(int row, int col,int i, int j,vector<vector<int>>&matrix,vector<vector<int>>&dp){
      if(dp[i][j] != -1)return dp[i][j];
       int down = 1;
        int left = 1;
        int right = 1;
        int up = 1;
        //Down Movement
         if(i+1<row && matrix[i+1][j] > matrix[i][j]){
            down = 1 + solve(row,col,i+1,j,matrix,dp);
     
        }
       
        //Left Movement
        if(j-1>=0 &&  matrix[i][j-1]>matrix[i][j]){
            
         left  = 1 + solve(row,col,i,j-1,matrix,dp);
           
        }
       
        //Right Movement
        if(j+1 < col && matrix[i][j+1]>matrix[i][j]){
            
             right = 1 + solve(row,col,i,j+1,matrix,dp);
            
        }
       
        //Up Movement
        if(i-1 >=0 && matrix[i-1][j]>matrix[i][j]){
  
            up = 1 + solve(row,col,i-1,j,matrix,dp);
            
        }
        
        return dp[i][j] = max(up,max(down,max(left,right)));
        
        
    }
};