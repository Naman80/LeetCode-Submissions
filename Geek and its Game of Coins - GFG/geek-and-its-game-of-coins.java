// { Driver Code Starts
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
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int findWinner(int N,int X,int Y)
    {
        int[] xwin = new int[N+1];
        int[] ywin = new int[N+1];
        
        xwin[1] = 1;
        ywin[1] = 1;
        
        
        for(int i = 2;i<N+1;i++){
            
            if(i<X && i<Y){
                if(ywin[i-1]==0)xwin[i] = 1;
                if(xwin[i-1]==0)ywin[i] = 1;
            }else if (i>=X && i<Y){
                if(ywin[i-1] == 0 || ywin[i-X]==0)xwin[i] = 1;
                 if(xwin[i-1] == 0 || xwin[i-X]==0)ywin[i] = 1;
            }else if(i>=Y && i < X){
                if(ywin[i-1] == 0 || ywin[i-Y]==0)xwin[i] = 1;
                if(xwin[i-1] == 0 || xwin[i-Y]==0)ywin[i] = 1;
            }else{
                if(ywin[i-1] == 0 || ywin[i-X]==0 || ywin[i-Y] ==0 )xwin[i] = 1;
                if(xwin[i-1] == 0 || xwin[i-X]==0 || xwin[i-Y] ==0 )ywin[i] = 1;
            }
            
        }
        return xwin[N];
    }
}