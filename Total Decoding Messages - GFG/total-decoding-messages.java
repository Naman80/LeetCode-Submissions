//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int mod = 1000000007;
    public int CountWays(String str)
    {
        int n = str.length();
        Integer[] dp = new Integer[n+1];
        return solve(0 , str ,n , dp);
    }
    public int solve(int idx , String str , int n , Integer[] dp){
        
        if(idx>= str.length())return 1;
        if(dp[idx]!=null)return dp[idx];
        int ans=0;
        char ch = str.charAt(idx);
        if(ch >= '1' && ch <= '9'){
            ans+= solve(idx+1 , str , n,dp)%mod;
        }
        if(idx != n-1){
            char next = str.charAt(idx+1);
            if(ch == '1' && (next >= '0' && next <= '9')){
                ans+=solve(idx+2 , str,n,dp)%mod;
            }
            if(ch == '2' && (next >= '0' && next <= '6')){
                ans+=solve(idx+2 , str,n,dp)%mod;
            }
        }
        return dp[idx] = ans%mod;
    }
}