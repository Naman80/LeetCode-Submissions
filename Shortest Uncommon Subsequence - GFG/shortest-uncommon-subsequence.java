// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A[] = read.readLine().split(" ");
            
            String S = A[0];
            String T = A[1];

            Solution ob = new Solution();
            System.out.println(ob.shortestUnSub(S,T));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int[][] dp = new int[501][501];
    static int shortestUnSub(String s, String t) {
        
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        int ans = solve(s,t,0,0);
        if(ans>=501)return -1;
        return ans;
        
        
    }
    
    
    static int solve(String s , String t , int i , int j){
        
        
        if(i >= s.length())return 501;
        if(j >= t.length())return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int k = j;
        
        for(;k<t.length();k++){
            if(s.charAt(i) ==t.charAt(k)){
                break;
            }
        }
        
        if(k==t.length())return 1;
        
        return dp[i][j] = Math.min(solve(s,t,i+1,j),1+solve(s,t,i+1,k+1));
        
    }
    
    
       
    
}