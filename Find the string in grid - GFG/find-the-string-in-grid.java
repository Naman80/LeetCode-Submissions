// { Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        ArrayList<Pair> ans = new ArrayList<>();
        
        char ch = word.charAt(0);
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0;i< n ; i++){
            for(int j = 0 ; j< m;j++){
                
                if(grid[i][j] == ch){
                    
                    boolean tl = solve(i,j,n,m,"tl",grid,0,word);
                    boolean t = solve(i,j,n,m,"t",grid,0,word);
                    boolean tr = solve(i,j,n,m,"tr",grid,0,word);
                    boolean l = solve(i,j,n,m,"l",grid,0,word);
                    boolean r = solve(i,j,n,m,"r",grid,0,word);
                    boolean bl = solve(i,j,n,m,"bl",grid,0,word);
                    boolean b = solve(i,j,n,m,"b",grid,0,word);
                    boolean br = solve(i,j,n,m,"br",grid,0,word);
                    
                    if(tl||t||tr||l||r||bl||b||br){
                    ans.add(new Pair(i,j));
                }
                }
                
                
                
            }
        }
        
        
       int[][] ret = new int[ans.size()][2];
       
       for(int i = 0 ; i < ans.size();i++){
           
           Pair p = ans.get(i);
           
           ret[i][0] = p.x;
           ret[i][1] = p.y;
           }
           
           
           return ret;
        
    }
    
    
    
boolean solve(int r ,int c , int n , int m , String dir ,char[][] grid , int idx ,String word){
        
        
        
        if(r < 0 || c <0 || r >= n || c>=m)return false;
        
        if(grid[r][c] != word.charAt(idx))return false;
        
        if(idx == word.length()-1){
            return true;
        }
        
        
        if(dir == "tl"){
            return solve(r-1,c-1,n,m,dir,grid,idx+1,word);
        }
        
        
        if(dir == "t"){
            return solve(r-1,c,n,m,dir,grid,idx+1,word);
        }
        
        
        if(dir == "tr"){
            return solve(r-1,c+1,n,m,dir,grid,idx+1,word);
        }
        
        if(dir == "l"){
            return solve(r,c-1,n,m,dir,grid,idx+1,word);
        }
        
        if(dir == "r"){
            return solve(r,c+1,n,m,dir,grid,idx+1,word);
        }
        
        if(dir == "bl"){
            return solve(r+1,c-1,n,m,dir,grid,idx+1,word);
        }
        
        if(dir == "b"){
            return solve(r+1,c,n,m,dir,grid,idx+1,word);
        }
        
        if(dir == "br"){
            return solve(r+1,c+1,n,m,dir,grid,idx+1,word);
        }
        
        
        
        
        return false;
        
        
    }
    
    
    
}

class Pair{
    
    int x;int y;
    
    Pair(int i , int j){
        this.x = i;
        this.y = j;
    }
    
}