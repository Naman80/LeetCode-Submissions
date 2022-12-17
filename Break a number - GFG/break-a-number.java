//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.waysToBreakNumber(N));
        }
    }
}
// } Driver Code Ends



class Solution{
    int mod = 1000000007;
    int waysToBreakNumber(int N){
        long n = (long)(N)+1;
        long ways = (((n%mod )* ((n+1)%mod))/2)%mod;
        return (int)(ways%mod);
    }
}

