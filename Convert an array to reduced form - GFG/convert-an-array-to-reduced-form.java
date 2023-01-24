//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        //Code here
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < n ; i++){
            pq.add(new pair(arr[i] , i));
        }
        
        for(int i = 0 ; i < n ; i++){
            pair out = pq.remove();
            
            arr[out.idx] = i;
        }
        
    }
}

class pair implements Comparable<pair>{
    int val;
    int idx;
    pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
    @Override public int compareTo(pair o)
    {
        return this.val - o.val;
    }
}