class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        bfs(n,m,grid);
        int ans = 0;
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ; j < m;j++){
                if(grid[i][j]==1)return -1;
                ans = Math.max(ans,grid[i][j]);
            }
        }if(ans==0)return ans;
        return ans-3; 
    }
    
    void bfs( int n, int m , int[][] grid){
        Queue<Pair> q = new LinkedList<>();
        for(int r = 0 ; r < n ; r++){
            for(int c = 0;c<m;c++){
                if(grid[r][c]==2){
                    q.add(new Pair(r,c));
                    grid[r][c] = 3;
                }
            }
        }
        int[] dirx = {1,-1,0,0};
        int[] diry = {0,0,-1,1};
        while(q.size()!=0){
            Pair p1 = q.poll();
            int x = p1.x;
            int y = p1.y;
            for(int  i = 0 ;i<4;i++){
                int newx = x + dirx[i];
                int newy = y + diry[i];
                if( newx<0 || newx >=n || newy<0 || newy >=m) continue;
                if( grid[newx][newy] == 1 ){
                    grid[newx][newy] = grid[x][y]+1;
                    // grid[newx][newy] = 0;
                    q.add(new Pair(newx,newy));
                }
            }
        }
    }
}

class Pair{
    int x;int y;
    Pair(int r,int c){
        this.x = r;
        this.y = c;
    }
}