//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        Vector<Integer> ans = new Vector<>(2);
        char[] arr = str.toCharArray();
        int l = 0 ;
        int r = 0 ;
        int one = 0;
        int zero = 0;
        int ansl = 0;
        int ansr = 0;
        int prev = 0;
        while(r < n){
            if(arr[r]=='1')one++;
            else zero++;
            if(zero - one < 0){
                l = r+1;
                zero = 0;
                one = 0;
            }else{
                if(prev < zero - one){
                    prev = zero - one;
                    ansl = l+1;
                    ansr = r+1;
                }
            }
            r++;
        }
        if(ansl!=0){ans.add(ansl);
        ans.add(ansr);
        }else ans.add(-1);
        return ans;
        
    }
}