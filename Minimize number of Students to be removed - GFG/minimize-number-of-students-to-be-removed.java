//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] arr, int n) {
        // int[] dp = new int[n];
        // int maxlen = 0;
        // for(int i = 0 ; i < n;i++){
        //     int max = 0;
        //     for(int j = 0 ; j < i ; j++){
        //         if(arr[i] > arr[j]){
        //             max  = Math.max(max , dp[j]);
        //         }
        //     }
        //     dp[i] = max+1;
        //     maxlen = Math.max(maxlen , dp[i]);
        // }
        // return n - maxlen;
        
        ArrayList<Integer> al = new ArrayList<>();
        int ans = 0;
         for(int i = 0 ; i<n ; i++){
             if( al.isEmpty() || arr[i] > al.get(al.size()-1) ){
                 al.add(arr[i]);
                 ans++;
             }else{   
                int pos =  Collections.binarySearch(al,arr[i]);
                if(pos<0){
                    pos = Math.abs(pos+1);
                    al.set(pos,arr[i]);
                }
             }  
         }
         return n- ans;
    }
};