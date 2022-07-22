class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        Boolean[][] vis = new Boolean[n][m];
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j<m;j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1 && vis[i][j] == null){
                        dfs(i,j,grid,vis);
                    }
                }
            }
        }
        int ans = 0 ;
        for(int i = 0 ; i < n ;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==null && grid[i][j]==1)ans++;
            }
        }
        
        return ans;
        
    }
    
    
    void dfs(int r,int c , int[][]grid , Boolean[][] vis){
        
        if(r < 0 || c < 0 || r >=grid.length || c >= grid[0].length || grid[r][c] == 0)return;
        if(vis[r][c]!=null)return;
        vis[r][c] = false;
        dfs(r+1,c,grid,vis);
        dfs(r,c+1,grid,vis);
        dfs(r,c-1,grid,vis);
        dfs(r-1,c,grid,vis);    
        
    }
}