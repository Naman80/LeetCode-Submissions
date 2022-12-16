//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            String a1[] = in.readLine().trim().split("\\s+");
            int ty = Integer.parseInt(a1[0]);
            int i = Integer.parseInt(a1[1]);
            int j = Integer.parseInt(a1[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.hopscotch(n, m, mat, ty, i, j));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] oddx = {-1,0,1, 1,1,0 };
    static int[] oddy = {0,1, 1, 0,-1,-1};
    static int[] evenx ={-1,-1, 0,1,0 ,-1};
    static int[] eveny ={0,  1, 1,0,-1,-1};
    
    static int hopscotch(int n, int m, int mat[][], int ty, int i, int j) 
    {
        
        boolean[][] vis = new boolean[n][m];
        
        vis[i][j] = true;
        
        return solve(i , j , n , m , mat , vis , ty);
        
    }
    
    static int solve(int r , int c , int n , int m , int[][]mat , boolean[][]vis , int step){
        int sum = 0;
        if(c%2==0){
            for(int i = 0 ; i < 6 ; i++){
                int newx = r + evenx[i];
                int newy = c + eveny[i];
                if(newx <0||newy<0||newx>=n ||newy>=m || vis[newx][newy])continue;
                vis[newx][newy] = true;
                if(step==0){
                    sum+= mat[newx][newy];
                }
            }
            
            if(step==1){
                
                for(int i = 0 ; i < 6 ; i++){
                int newx = r + evenx[i];
                int newy = c + eveny[i];
                if(newx <0||newy<0||newx>=n ||newy>=m )continue;
                    sum+= solve(newx, newy , n , m ,mat , vis, 0);
                }
            }
            
        }else{
            for(int i = 0 ; i < 6 ; i++){
                int newx = r + oddx[i];
                int newy = c + oddy[i];
                if(newx <0||newy<0||newx>=n ||newy>=m || vis[newx][newy])continue;
                vis[newx][newy] = true;
                if(step==0){
                    sum+= mat[newx][newy];
                }
            }
            if(step==1){
                for(int i = 0 ; i < 6 ; i++){
                int newx = r + oddx[i];
                int newy = c + oddy[i];
                if(newx <0||newy<0||newx>=n ||newy>=m )continue;
                    sum+= solve(newx, newy , n , m ,mat , vis, 0);
                }
            }
            
        }
        
        return sum;
        
        
    }
    
    
    
}