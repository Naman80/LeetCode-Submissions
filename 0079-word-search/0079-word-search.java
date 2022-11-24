class Solution {
    boolean ans = false;
    public boolean exist(char[][] mat, String target) {
        char ch = target.charAt(0);
        int n = mat.length;
        int m  = mat[0].length;
        int tlen = target.length();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0 ; j < m;j++){
                if(mat[i][j] == ch){
                    solve(i,j,n,m,0,tlen,mat,target,vis);
                          if(ans)return ans; 
                }
            }
        }
        return ans;
    }
    
    
     void solve(int r ,int c , int n , int m , int idx , int tlen ,char[][] mat , String tar,boolean[][] vis){
        if(r <0 || c <0 || r>=n || c>=m || vis[r][c] || mat[r][c] != tar.charAt(idx))return ;
        if(idx==tlen-1){
            ans = true;return;
        }
        vis[r][c] = true;
        // up
        solve(r-1,c,n,m,idx+1,tlen,mat,tar,vis);
        // right
        if(ans)return; 
        solve(r,c+1,n,m,idx+1,tlen,mat,tar,vis);
        if(ans)return; 
        // left
        solve(r , c-1,n,m,idx+1,tlen,mat,tar,vis);
        if(ans)return; 
        //down
        solve(r+1,c,n,m,idx+1,tlen,mat,tar,vis);
        if(ans)return; 
        vis[r][c] = false;
    }
}