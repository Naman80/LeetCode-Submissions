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
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int ans = 0;
    static boolean check = false;
    static int numberOfSubsequences(String s, String w){
        // code here
        int n = s.length();
        int m = w.length();
        ans = 0;
        boolean[] vis = new boolean[n];
        
        for(int i = 0 ; i < n ; i ++){
            if(s.charAt(i) == w.charAt(0) && !vis[i]){
                check = false;
                solve(i, 0 ,s ,w,vis);
                     if(!check)break;
            }
       
        }
        
        return ans;
    }
    
    static void solve(int idx , int idx2 ,String s, String w  , boolean[] vis){
        
            if(idx2 >= w.length()){
                check = true;
                ans++;
                return;
            }
            if(idx >= s.length())return;
            
        
        
        if(s.charAt(idx) == w.charAt(idx2) && !vis[idx]){
            vis[idx] = true;
            solve(idx+1 , idx2+1 , s ,w ,vis);
            return;
        }else{
            
            solve(idx+1,  idx2 , s, w,vis);
            return;
        }
        
        
        
        
    }
    
    
}