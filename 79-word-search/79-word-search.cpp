class Solution {
public:
    bool solve(vector<vector<char> > &mat, string target, int i, int j, int idx, int r, int c,vector<vector<bool>>&vis){
        //base case
         if(idx==target.size()){
            return true;
        }
        if(i<0 || j<0 || i>=r || j>=c || mat[i][j]!=target[idx] || vis[i][j]==1){
            return false;
        }
        vis[i][j] = 1;
        bool op1 = solve(mat,target,i+1,j,idx+1,r,c,vis)  ;
        bool op2 =solve(mat,target,i,j+1,idx+1,r,c,vis);
       bool op3 = solve(mat,target,i-1,j,idx+1,r,c,vis);
       bool op4 = solve(mat,target,i,j-1,idx+1,r,c,vis);
        vis[i][j] = 0;
        
        return op1||op2||op3||op4 ;
        
       
    }
    bool exist(vector<vector<char>>& board, string word) {
        int r = board.size();
        int c = board[0].size();
      
        
        for(int i = 0 ; i<r; i++){
            for(int j = 0; j<c;j++){
                vector<vector<bool>>vis(board.size(),vector<bool>(board[0].size(),false));
                if(board[i][j]==word[0]){
                     if(solve(board,word,i,j,0,r,c,vis)){
                         return true;
                     }
                }
            }
        }
        return false;;
    }
};