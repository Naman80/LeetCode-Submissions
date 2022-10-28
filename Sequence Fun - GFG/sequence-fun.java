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
            Solution ob = new Solution();
            int ans = ob.NthTerm(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int NthTerm(int n)
    {
        // code here
        int mod = 1000000007;
        long[] dp = new long[n+1];
        
        dp[0] = 2;
        for(int i = 1 ; i < n+1 ; i ++){
            
            dp[i] = (i+1)%mod * dp[i-1]%mod;
            dp[i]+=1;
            dp[i]%=mod;
            
        }
        
        return (int)dp[n-1];
    }
}