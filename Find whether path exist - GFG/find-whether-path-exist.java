//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    int[][] maze;
    public boolean is_Possible(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        maze = new int[n][m];
        for(int[]x:maze)Arrays.fill(x , Integer.MAX_VALUE);
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i <  n ; i++)
            for(int j = 0 ; j < m ; j++){
               if(grid[i][j] == 1){ maze[i][j] = 0;
                q.add(new pair(i,j));}
            }
        
        return check(q , n , m , grid);
        
        
    }
    
    public boolean check(Queue<pair> q , int n , int  m , int[][] grid){
        int[] xdir = { 0 , 0 , -1 , 1};
        int[] ydir = {-1 , 1 ,  0 , 0};
        while(q.size()!=0){
            pair out = q.remove();
            int x = out.x;
            int y = out.y;
            if(grid[x][y] == 2)return true;
            for(int i  = 0 ; i < 4; i++){
                int newx = x + xdir[i];
                int newy = y + ydir[i];
                if(newx <0 || newx >=n || newy < 0 || newy >= m || grid[newx][newy]==0 )continue;
                if(maze[newx][newy] <= maze[x][y]+1)continue;
                maze[newx][newy] = maze[x][y]+1;
                q.add(new pair(newx , newy));
            }
        }
        return false;
        
    }
}

class pair{
    int x ;
    int y;
    pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}