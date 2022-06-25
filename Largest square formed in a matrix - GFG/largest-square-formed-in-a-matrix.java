// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        
        int[][] dp = new int[n][m];
        int ans = 0;
        for(int i = 0 ; i < m;i++){
            dp[n-1][i] = mat[n-1][i];
            ans = Math.max(ans,dp[n-1][i]);
        }
        for(int i = 0 ; i < n;i++){
            dp[i][m-1] = mat[i][m-1];
            ans = Math.max(ans,dp[i][m-1]);
        }
        
       
        
        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                if(mat[i][j]==1){
                    dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1])) +1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        
        return ans;
        
    }
}