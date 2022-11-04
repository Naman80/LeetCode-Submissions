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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    String baseEquiv(int n, int m)
    {
        int i = 2;
        int j = 32;
        while(i<=j){
            int mid = (i+j)/2;
            int temp = nearestPower(n , mid) + 1;
            if(temp == m)
                return "Yes";
            else if(temp > m)
                i = mid +1 ;
            else j = mid-1;
        }
        return "No";
    }
    int nearestPower(int n, int mid)
    {
        int leftMostBit = (int)(Math.log(n) / Math.log(mid));
        return leftMostBit;
    }
}