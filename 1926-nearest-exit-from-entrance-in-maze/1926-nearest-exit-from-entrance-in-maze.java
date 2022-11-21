class Solution {
        int[][] grid;
            
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
            int m= maze[0].length;
            grid = new int[n][m];
            for(int[]x:grid)Arrays.fill(x , Integer.MAX_VALUE);
            
            return solve(entrance , maze , n , m);
            
            
            
    }
    
    
    public int solve(int[] enter , char[][] maze , int n , int m){
        int[] xdir = {0 , 0 , -1 , 1};
        int[] ydir = {-1, 1 , 0 , 0};
        
        Queue<pair> q = new LinkedList<>();
        int ans = -1;
        q.add(new pair(enter[0] , enter[1]));
        grid[enter[0]][enter[1]] = 0;
        while(q.size()!=0){
            pair out = q.poll();
            int x = out.x;
            int y = out.y;
            if((x == 0 || x == n-1 || y ==0 || y == m-1) && (grid[x][y]!=0)){ans = grid[x][y];break;}
            for(int j = 0 ; j < 4 ; j++){
                int newx = x + xdir[j];
                int newy = y +  ydir[j];
                if(newx < 0 || newy < 0 
                   || newx>=n || newy>=m || maze[newx][newy] == '+')continue;
                if(grid[newx][newy] <= grid[x][y]+1)continue;
                grid[newx][newy] = grid[x][y]+1;
                q.add(new pair(newx , newy));
            }
            
        }
        return ans;
    }
}

class pair{
    
    int x ;
    int y ;
    
    pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}