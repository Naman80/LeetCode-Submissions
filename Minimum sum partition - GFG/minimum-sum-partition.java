//{ Driver Code Starts
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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    Arrays.sort(arr);
	    int sum = 0;
	    for(int x : arr)sum+=x;
	    boolean[][] dp = new boolean[n+1][sum+1];
	    dp[0][0] = true;
	    for(int i = 1 ; i < n+1 ; i++){
	        
	        for(int j = 1; j < sum+1 ; j++){
	            
	            dp[i][j] = dp[i-1][j];
	            
	            if(arr[i-1] <= j){
	                
	                dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
	                
	            }
	            
	            
	        }
	        
	    }
	    
	    int min = Integer.MAX_VALUE;
	    
	    for(int i = 1 ; i <= sum ; i++){
	        
	        if(dp[n][i]){
	            min = Math.min(min , Math.abs( i - (sum - i)));
	        }
	        
	    }
	    
	    return min;
	    
	    
	} 
}
