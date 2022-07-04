// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        if(N==1)return "";
        HashMap<String , Integer> hm = new HashMap<>();
        
        for(String x : arr){
            
            hm.putIfAbsent(x,0);
            hm.put(x , hm.get(x)+1);
            
        }
        
        
        ArrayList<Integer> al = new ArrayList<>(hm.values());
        Collections.sort(al);
        int sm = al.get(al.size()-2);
        
        for(String x : hm.keySet()){
            if(hm.get(x) == sm)return x;
        }
        
        return "";
        
    }
}