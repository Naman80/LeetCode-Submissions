// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] pre)
    {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        int nlen = pre.length;
        
        for(int i = 0 ; i<nlen;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        
        boolean[] vis = new boolean[n];
        boolean[] rec = new boolean[n];
        
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,rec))return false;
            }
        }
        
        return true;
    }
    
    
    boolean dfs(int v , ArrayList<ArrayList<Integer>> adj,boolean[]vis,boolean[] rec){
        
        vis[v] = true;
        rec[v] = true;
        
        
        for(int x : adj.get(v)){
            if(!vis[x]){
                if(dfs(x,adj,vis,rec))return true;
            }else if(rec[x])return true;
        }
        
        rec[v] = false;
        
        return false;
    }
    
}