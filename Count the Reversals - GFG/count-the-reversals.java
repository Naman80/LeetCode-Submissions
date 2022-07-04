// { Driver Code Starts
//Initial Template for Java

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
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        int n = s.length();
        int open =0;int ans = 0;
        int close =0;
        
        for(int i = 0 ;i<n;i++){
            char ch = s.charAt(i);
            
            if(ch=='}'){
                if(open>0){
                    open--;
                }else{
                    ans++;
                    open++;
                }
            }else{
                open++;
            }
        }
        if(open%2==1)return -1;
        else ans+=open/2;
        return ans;
    }
}