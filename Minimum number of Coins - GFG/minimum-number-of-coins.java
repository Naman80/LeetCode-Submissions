//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        Pair[] dp = new Pair[N+1];
        dp[0] = new Pair(0 , 0);
        for(int i = 1 ; i < N+1 ; i++){
            int minval = 1;
            int min = Integer.MAX_VALUE;
            int val = 1;
            for(int j = 0 ; j < 11 ;  j++){
                if(val <= i){
                    Pair temp = dp[i - val];
                    if(min > temp.min+1){
                        min = temp.min+1;
                        minval = val;
                    }
                }else break;
                val = changeCurr(j);
            }
            dp[i] = new Pair(minval , min);
        }
        List<Integer> ans = new ArrayList<>();
        int temp = N;
        while(temp!=0){
            ans.add(0 ,dp[temp].num);
            temp = temp - dp[temp].num;
        }
        return ans;
    }
    static int changeCurr(int idx){
        switch(idx){
            case 1 : return 2;
            case 2 : return 5;
            case 3 : return 10;
            case 4 : return 20;
            case 5 : return 50;
            case 6 : return 100;
            case 7 : return 200;
            case 8 : return 500;
            case 9 : return 2000;
            default : return 1;
        }
    }
}
class Pair{
    int num;
    int min;
    Pair(int num , int min){
        this.num = num;
        this.min = min;
    }
}