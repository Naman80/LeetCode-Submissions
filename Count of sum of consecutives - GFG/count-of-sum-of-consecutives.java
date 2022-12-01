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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getCount(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getCount(int N) {
        // code here
        
        return countConsecutive(N);
    }
    
     static int countConsecutive(int N)
    {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            double a = (double)((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int)a == 0.0)
                count++;
        }
        return count;
    }
};