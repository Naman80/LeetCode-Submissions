// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        
        
        Arrays.sort(arr);
        
        HashMap<String,Integer> hm = new HashMap<>();
        
        
        for(String s : arr){
            hm.putIfAbsent(s , 0);
            hm.put(s,hm.get(s)+1);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i : hm.values()){
            max = Math.max(max,i);
        }
        
        String[] ans  = new String[2];
        
        
        for(String s : arr){
            if(hm.get(s)==max){
                ans[0] = s;
                break;
            }
            
        }
        ans[1] = ""+max;
        
        return ans;
        
        
    }
}

