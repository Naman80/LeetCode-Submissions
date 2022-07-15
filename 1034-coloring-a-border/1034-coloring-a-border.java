class Solution {
    
    int[] xdir = {-1,0,1,0};
    int[] ydir = { 0,1,0,-1};
    int n;
    int m;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        bfs(row,col,color,grid,vis);
        return grid;
        
    }
    
    public void bfs(int r , int c ,int color , int[][] grid , boolean[][] vis){
        int inicolor = grid[r][c];
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        while(q.size()!=0){
            Pair out = q.poll();
            for(int i = 0 ;i<4;i++ ){
                int newX = xdir[i] + out.x;
                int newY = ydir[i] + out.y;
                
                if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                    grid[out.x][out.y] = color;
                    continue;
                }
                if(vis[newX][newY])continue;
            
            if(grid[newX][newY]!= inicolor){
               grid[out.x][out.y] = color;
                    continue; 
            }
                if(!vis[newX][newY]){
                       q.add(new Pair(newX,newY));
                    vis[newX][newY] =true;
                }
             
            }
        }
    }
    
}


class Pair{
    int x;
    int y;
    Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}