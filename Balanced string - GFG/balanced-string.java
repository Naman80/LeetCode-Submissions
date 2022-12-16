//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        int time =  N/26;
        int rem = N%26;
        String ans = times(time);
        ans+=solve(rem,N);
        return ans;
    }
    
    static String times(int time){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < time ; i++){
            for(int j = 0 ; j < 26 ; j++){
                 String ch = String.valueOf((char)(97+j));
                 sb.append(ch);
            }
        }
        
        return String.valueOf(sb);
    }
    static String solve(int n , int N){
        int start = n%2==0?n/2:sum(N)%2!=0?n/2:(n+1)/2;
        int back = n - start;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < start ; i++){
            String ch = String.valueOf((char)(97+i));
            sb.append(ch);
        }
        for(int i = back-1 ; i>=0; i--){
            String ch = String.valueOf((char)(122-i));
            sb.append(ch);
        }
        return String.valueOf(sb);
    }
    static int sum(int n){
        
        int sum = 0;
        
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
        
    }
}