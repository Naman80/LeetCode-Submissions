class Solution {
      int[] xdir = {-1,0,1,0};
    int[] ydir = { 0,1,0,-1};
    int n;
    int m;
    public int islandPerimeter(int[][] grid) {
         n = grid.length;
        m = grid[0].length;
        int max = 0;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < m ;j++){
                if(grid[i][j]==1){
                    max = Math.max(max,bfs(i,j,grid , new boolean[n][m]));
                    // break;
                }
            }
        }
        
        return max;
        
        
    }
  
    public int bfs(int r , int c , int[][] grid,boolean[][] vis){   
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r,c));
        int count = 0;
        // grid[r][c] = 0;
        vis[r][c] = true;
        while(q.size()!=0){
            Pair out = q.poll();
             grid[out.x][out.y] = 0;
            count+=4;
            for(int i = 0 ;i<4;i++ ){
                int newX = xdir[i] + out.x;
                int newY = ydir[i] + out.y;
                if( newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY]==0 )continue;
                if(!vis[newX][newY]){
                     
                     vis[newX][newY] = true;
                     q.add(new Pair(newX,newY));
                }  
                count-=2;
            }
        }
        return count;
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