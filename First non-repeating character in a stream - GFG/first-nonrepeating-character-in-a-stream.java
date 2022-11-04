//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String s)
    {
        // code here
        int n = s.length();
        StringBuilder sb = new StringBuilder();
       
        int[] map = new int[26];
        int j = 0;
        for(int i = 0; i < n ; i++){
            
            map[s.charAt(i) - 'a']++;
            
            while(j<=i){
                if(map[s.charAt(j) - 'a'] ==1)break;
                else j++;
            }
            
            if(j>i)sb.append('#');
            else sb.append(s.charAt(j));
            
        }
        return String.valueOf(sb);
    }
}