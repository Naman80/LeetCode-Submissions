//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int n = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[n];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxDistance(arr, n);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        int max_sum = Integer.MIN_VALUE;
        int min_sum = Integer.MAX_VALUE;
        int max_diff = Integer.MIN_VALUE;
        int min_diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i ++){
            int sum = arr[i]+i;
            int diff = arr[i]-i;
            max_sum = Math.max(sum , max_sum);
            min_sum = Math.min(sum , min_sum);
            max_diff = Math.max(diff , max_diff);
            min_diff = Math.min(diff , min_diff);
        }
        return Math.max(max_sum - min_sum , max_diff - min_diff);
        
        
        
    
    }
    
    
}


