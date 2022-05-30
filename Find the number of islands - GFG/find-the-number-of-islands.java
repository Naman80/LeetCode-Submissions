// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
       
       int r = grid.length;
       int c = grid[0].length;
       int com = 0;
       for(int i = 0 ; i < r ; i++){
           for(int j = 0 ; j < c ; j++){
               if(grid[i][j] == '1'){
                   com++;
                   dfs(i,j,grid);
               }
           }
       }
       
       return com;
       
    }
    
    
    void dfs(int i,int j ,char[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        
        if(i<0 || j<0 || i>=r || j >=c || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
        dfs(i-1,j-1,grid);
        dfs(i+1,j+1,grid);
        dfs(i-1,j+1,grid);
        dfs(i+1,j-1,grid);
    }
}