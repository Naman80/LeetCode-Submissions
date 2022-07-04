// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int ans = 0;
    public int findOccurrence(char mat[][], String target)
    {

        char ch = target.charAt(0);
        int n = mat.length;
        int m  = mat[0].length;
        int tlen = target.length();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0 ; j < m;j++){
                if(mat[i][j] == ch){
                    solve(i,j,n,m,0,tlen,mat,target,vis);
                }
            }
        }

        return ans;

    }


    void solve(int r ,int c , int n , int m , int idx , int tlen ,char[][] mat , String tar,boolean[][] vis){



        if(r <0 || c <0 || r>=n || c>=m || vis[r][c] || mat[r][c] != tar.charAt(idx))return ;

        if(idx==tlen-1){
            ans++;return;
        }

        vis[r][c] = true;
        // up
        solve(r-1,c,n,m,idx+1,tlen,mat,tar,vis);

        // right

        solve(r,c+1,n,m,idx+1,tlen,mat,tar,vis);


        // left

        solve(r , c-1,n,m,idx+1,tlen,mat,tar,vis);


        //down

        solve(r+1,c,n,m,idx+1,tlen,mat,tar,vis);


        vis[r][c] = false;


    }
    
    
}