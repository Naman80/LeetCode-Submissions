class Solution {
    public int maxDistance(int[][] grid) {
           int n  = grid.length;

        int count = 1;


        while(true){
            boolean check = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]==count){
                        if (i-1>=0 && grid[i-1][j]==0){
                            grid[i-1][j]=count+1;
                            check = false;
                        }
                        if (j-1>=0  && grid[i][j-1]==0){
                            grid[i][j-1]=count+1;
                            check = false;
                        }
                        if (i+1<n  && grid[i+1][j]==0){
                            grid[i+1][j]=count+1;
                            check = false;
                        }
                        if (j+1<n  && grid[i][j+1]==0){
                            grid[i][j+1]=count+1;
                            check = false;
                        }
                    }
                }
            }
            if (check)break;else count++;
        }
        if(count-1==0)return -1;
        return count-1;

        
        
//         int n  = grid.length;
//         int max = Integer.MIN_VALUE;
//         boolean[][] vis = new boolean[n][n];
//         for(int i = 0;i<n;i++){
//             for(int j = 0 ; j < n;j++){
//                 if(grid[i][j]==0){
//                     int temp = solve(i,j,i,j,grid,vis);
//                     max = Math.max(temp,max);
//                 }
                
//             }
//         }
        
//         if(max==Integer.MAX_VALUE || max == Integer.MIN_VALUE)return -1;
//         return max;
    }
    
    
//     int solve(int r, int c,int sr,int sc,int[][]grid,boolean[][] vis){
        
        
//         if(grid[r][c]==1){
//             return Math.abs(sr-r)+Math.abs(sc-c);
//         }
        
//         vis[r][c]= true;
//         int up=Integer.MAX_VALUE;
//         int down=Integer.MAX_VALUE;
//         int right=Integer.MAX_VALUE;
//         int left=Integer.MAX_VALUE;
//         if(r-1>=0 && !vis[r-1][c]){
//             up = solve(r-1,c,sr,sc,grid,vis);
//         }
        
//         if(r+1<grid.length && !vis[r+1][c]){
//             down = solve(r+1,c,r+1,c,grid,vis);
//         }
        
//         if(c-1>=0 && !vis[r][c-1]){
//             left = solve(r,c-1,r,c-1,grid,vis);
//         }
        
//         if(c+1<grid.length && !vis[r][c+1]){
//             right = solve(r,c+1,r,c+1,grid,vis);
//         }
//         vis[r][c] = false;
        
//         return Math.min(up,Math.min(down,Math.min(left,right))) + 1;
        
        
//     }
}