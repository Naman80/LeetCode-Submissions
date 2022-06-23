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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        int mod = 1000000007;
        long inc = 1;
        long exc = 1;
        for(int  i = 1;i<=N;i++){
            long ninc = exc;
            long nexc = (inc+exc)%mod;
            inc = ninc%mod;
            exc = nexc%mod;
        }
        // int temp = exc;
        // for(int i = 1 ; i < temp;i++){
        //     exc = (exc + temp)%mod;
        // }
  
        return (int)((exc*exc)%1000000007);
    }
}