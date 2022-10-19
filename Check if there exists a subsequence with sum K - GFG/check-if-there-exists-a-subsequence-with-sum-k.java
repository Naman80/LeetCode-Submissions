//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here

Boolean[][] dp = new Boolean[N+1][K+1];
    return solve(0 , K , arr , dp);
  }
  
  
  static boolean solve(int idx , int k , int[] arr, Boolean[][] dp){
      
      
      if(k==0)return true;
      if(idx>=arr.length)return false;
      
      if(dp[idx][k]!=null)return dp[idx][k];
      boolean p1= false;
      if(k-arr[idx] >=0)p1 = solve(idx+1 , k - arr[idx], arr , dp);
      boolean p2 = solve(idx+1 , k ,arr , dp);
      return dp[idx][k] = p1||p2;
      
      
      
      
  }
}
     