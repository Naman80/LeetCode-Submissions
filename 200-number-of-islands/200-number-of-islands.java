class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int com=0;
        int c = grid[0].length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                
                if(grid[i][j] == '1'){
                    com++;
                    bfs(i,j,grid);
                }
                
            }
        }
        
        return com;
        
    }
    
    
    void bfs(int i,int j , char[][]grid){
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] o = q.poll();
            i = o[0];
            j = o[1];
            if(i+1<r && grid[i+1][j]=='1'){
                grid[i+1][j] = '0';
                q.add(new int[]{i+1,j});
            }
            
            if(j+1 < c && grid[i][j+1] == '1'){
                grid[i][j+1] = '0';
                q.add(new int[]{i,j+1});
            }
            
           if(i-1>=0 && grid[i-1][j]=='1'){
                grid[i-1][j] = '0';
                q.add(new int[]{i-1,j});
            }
            
             if(j-1 >=0 && grid[i][j-1] == '1'){
                grid[i][j-1] = '0';
                q.add(new int[]{i,j-1});
            }
        }
        
        
    }
}