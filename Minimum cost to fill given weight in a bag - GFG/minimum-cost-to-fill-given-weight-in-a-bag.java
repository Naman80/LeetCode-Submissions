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
                    int n = sc.nextInt();
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    // } Driver Code Ends


class Solution
{
	public int minimumCost(int cost[], int N,int W)
	{
		int n = cost.length;
		
		int[][] dp = new int[W+1][n+1];
		
		for(int i = 1;i<n+1;i++){
		    dp[0][i] = 0;
		}
		
		
        for(int i = 1 ; i<W+1;i++){
            dp[i][0] = (int)(1e8);
        }

		
		for(int i = 1 ; i<W+1;i++){
		    for(int j = 1 ; j < n+1 ; j++ ){
		        
		        if(j<=i && cost[j-1]!=-1){
		            dp[i][j] = Math.min(cost[j-1]  + dp[i-j][j] , dp[i][j-1] );
		          //  System.out.print(dp[i][j] + " ");
		        }else{
		            dp[i][j] = dp[i][j-1];
		          //  System.out.print(dp[i][j] + " ");
		        }
		        
		    }
		  //  System.out.println();
		    
		}
		
		if(dp[W][n]<0)return -1;
		return dp[W][n];
		
		
		
	}
}