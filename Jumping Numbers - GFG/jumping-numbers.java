//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Long> dp = new ArrayList<>();
    static int btn = 0;
    static long jumpingNums(long X) {
        // code here
        if(btn==0){
            help();
            btn=1;
        }
        
        // System.out.println(dp);
        
        
        int idx = Collections.binarySearch(dp , X);
        
        if(idx<0){
            idx = Math.abs(idx+1)-1;
        }
        
        return dp.get(idx);
    
        
        
    }
    static void help(){
        for(int i =1 ; i <= 10 ; i++){
            for(int j = 1; j <= 9 ; j++){
                String temp = ""+j;
                helper2(i , j , temp);
            }
        }
    }
    static void helper2(int dig ,int prev , String s){
        
        if(s.length()==dig){
            dp.add(Long.parseLong(s));
            return ;
        }
        
        for(int i = 0 ; i <= 9 ; i++){
            if(Math.abs(prev - i) ==1){
                helper2(dig,i , s+i);
            }
        }
        
    }
    
};