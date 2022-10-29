//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        
        int n = arr.length;
        for(int i = 0 ; i <=  n-4 ; i++ ){
            if(i>0 && arr[i] == arr[i-1])continue;
            for(int j = i+1 ; j <= n - 3 ; j ++ ){
                if(j > i+1 && arr[j]==arr[j-1])continue;
                int lo  = j+1;
                int hi = n-1;
                while(lo < hi){
                    while(lo>j+1 && lo < hi && arr[lo] == arr[lo-1])lo++;
                    while(hi < n-1 && lo < hi && arr[hi] == arr[hi+1])hi--;
                    
                    if(lo>=hi)break;
                    int sum = arr[i] + arr[j] + arr[lo] + arr[hi];
                    if(sum==k){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[lo]);
                        temp.add(arr[hi]);
                        ans.add(temp);
                        lo++;
                        hi--;
                    }else if(sum < k){
                        lo++;
                    }else hi--;
                }
            }
        }
        
        return ans;
        
    }
}