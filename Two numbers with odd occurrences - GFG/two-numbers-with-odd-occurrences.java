//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
        int xor = 0;
        for(int  x: arr)xor^=x;
        int temp = xor;
        int bit = 0;
        for(int i = 0 ; i < 32 ;  i++)if((xor & (1<<i))!=0)bit = i;
        for(int x : arr)if(((x>>bit)&1) == 1)temp^=x;
        int a = temp;
        int b = temp^xor;
        int[] ans = new int[2];
        if(a>b){
            ans[0] = a;
            ans[1] = b;
        }else {
            ans[1] = a;
            ans[0] = b;
        }
        return ans;
    }
}