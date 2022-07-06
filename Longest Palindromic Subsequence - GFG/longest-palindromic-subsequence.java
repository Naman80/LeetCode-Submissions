// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        
        String s2 = String.valueOf(new StringBuilder(S).reverse());
        
        return lcs(S,s2);
        
        
    }
    
    
    int lcs(String s1 , String s2){
        
        int n1 = s1.length();
        int n2 = s2.length();
        
        int[][] dp = new int[n1+1][n2+1];
        
        
        for(int i = 0 ; i <= n1 ; i++){
            for(int j = 0 ;j<=n2;j++){
                
                if(i==0 || j == 0)continue;
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
                
            }
        }
        
        return dp[n1][n2];
        
    }
    
}