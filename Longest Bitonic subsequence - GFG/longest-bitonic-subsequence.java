//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int[] inc = new int[n];
        inc[0] = 1;
        for(int i = 1; i < n; i ++){
            int max = 0;
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max , inc[j]);
                }    
            }
            inc[i] = max+1;
        }
        int[] dec = new int[n];
        dec[n-1] = 1;
        for(int i = n-2; i >=0; i--){
            int max = 0;
            for(int j = n-1 ; j >i ; j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max , dec[j]);
                }    
            }
            dec[i] = max+1;
        }
        
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++){
            ans = Math.max(ans , inc[i] + dec[i]);
        }
        
        return ans-1;
        
        
        
        
    }
}