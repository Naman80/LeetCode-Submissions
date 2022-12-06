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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    int[][] ans;
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        ans= new int[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j < m ; j++){
                ans[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 1){
                    ans[i][j] = 0;
                    q.add(new pair(i , j));
                }
            }
        
        solve(q , n , m , grid);
        
        return ans;
        
        
    }
    
    
    void solve(Queue<pair>q , int n , int m ,int[][] grid){
        int[] xdir = {0,0,-1,1,1,1,-1,-1};
        int[] ydir = {-1,1,0,0,1,-1,1,-1};
        while(q.size()!=0){
            pair out = q.poll();
            int x = out.x;
            int y = out.y;
            for(int i = 0 ; i < 8 ; i++){
                int newx = xdir[i] + x;
                int newy = ydir[i] + y;
                if(newx <0 || newy < 0 || newy >= m || newx >= n
                || grid[newx][newy] == 1 )continue;
                int dis = Math.abs(newx - x) + Math.abs(newy - y) + ans[x][y];
                if(dis < ans[newx][newy]){
                    ans[newx][newy] = dis;
                    q.add(new pair(newx,newy));
                }
            }
        }
    }
    
    
}

class pair{
    
    int x;int y;
    
    pair(int x , int y){
        this.x = x;
        this.y =y;
    }
    
    
}