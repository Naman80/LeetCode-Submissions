//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static int mod = 1000000007;
    static int[] xdir = {1 , 1 , -1, -1 , 2 , 2 , -2, -2 };
    static int[] ydir = {2 , -2 , 2 , -2 , 1 , -1 , 1 , -1};
    static long numOfWays(int N, int M)
    {
        
        long ans = 0;
        long tot = N * M;
        for(int i=  0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                long count = 1;
                for(int k = 0 ; k < 8 ; k++){
                    int newx = xdir[k] + i;
                    int newy = ydir[k] + j;
                    if(newx < 0 || newy < 0 || newx>=N || newy >=M)continue;
                    else count++;
                }
                ans+= (tot - count)%mod;
                ans%=mod;
            }
        }
        return ans;
        
    }
}