//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int[] dp = new int[n+1];
       dp[0]=1;
       for(int i =1 ; i < n+1 ; i++){
           int temp1 = 0;
           int temp2 = 0;
           int temp3 = 0;
           if(i>=x && dp[i-x]!=0){
               temp1 = dp[i-x];
           }
           if(i>=y && dp[i-y]!=0){
               temp2 = dp[i-y];
           }
           if(i>=z && dp[i-z]!=0){
               temp3 = dp[i-z];
           }
           int max = Math.max(Math.max(temp1 , temp2),temp3);
           if(max==0)continue;
           dp[i] = max+1;
       }
       
       return dp[n]!=0?dp[n]-1:0;
    }
}
