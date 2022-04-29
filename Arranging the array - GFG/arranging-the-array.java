// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Compute {
    
    public void Rearrange(long a[], long n)
    {
        mergeSort(a,0,(int)n-1);
    }
    
    
   void mergeSort(long[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r );
        }
    }
    
    void merge(long[] arr, int l, int mid, int r) {

        int i = l;
        int j = mid + 1;
        
        while(i<=mid && arr[i] < 0) i++;
        
        while(j <= r && arr[j] < 0) j++;
        
        
        reverse(arr,i,mid);
        
        reverse(arr,mid+1,j-1);
        
        reverse(arr,i,j-1);
       
    }
    
    void reverse(long[] a,int i ,int j){
        
        
        while(i<j){
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        
    }
    
}