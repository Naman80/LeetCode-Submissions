class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Boolean[][] vis = new Boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i==0 || j==0 || i == n-1 || j == m-1){
                    if(grid[i][j]==0)vis[i][j] = false;
                    else vis[i][j] = true;
                }else if(grid[i][j]==1){
                    vis[i][j] = true;
                }
                // System.out.print(vis[i][j] + " ");
            }
            // System.out.println();
        }
        
        int count = 0;
        for(int i = 1 ; i < n-1;i++){
            for(int j = 1; j < m-1;j++){
                if(grid[i][j]==0 && vis[i][j]==null){
                    if(solve(i,j,grid,vis))count++;
                }
            }
        }
        
        return count;
        
        
        
    }
    
    
    boolean solve(int r , int c , int[][] grid , Boolean[][] vis){
        
        // if(r<0 || c <0 || r>=grid.length || c >= grid[0].length)return false;
        
        if(vis[r][c]!=null){
            if(!vis[r][c])return false;
            if(vis[r][c])return true;
        }
         vis[r][c] = true;
        
        boolean left = solve(r,c-1,grid,vis);
        boolean right = solve(r,c+1,grid,vis);
        boolean top = solve(r-1,c,grid,vis);
        boolean down = solve(r+1,c,grid,vis);
        
        if(left && right && top && down){
            vis[r][c] = true;
            return true;
        }else{
            vis[r][c] = false;
            return false;
        }
    }
}