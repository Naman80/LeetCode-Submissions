// { Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    
    int mod = 1000000007;
    int  subsequenceCount(String S, String T)
    {
        
        int n = S.length();
        int m = T.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0 ; i < n+1;i++){
            dp[0][i] = 1;
        }
        
        for(int i = 0; i < m+1;i++){
            for(int j = 0; j < n+1 ;j++){
                if(i==0 || j==0)continue;
                
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = (dp[i][j-1]%mod + dp[i-1][j-1]%mod)%mod;
                }else{
                    dp[i][j] = dp[i][j-1]%mod;
                }
                
            }
        }
        
        return dp[m][n];
        
        
        
        
        // Integer[][] dp = new Integer[n][m];
        // return solve(S,T ,dp);
	
    }
    
    int solve(String S , String T ,Integer[][] dp){
        
        
        int n = S.length()-1;
        int m = T.length()-1;
        
        if(m < 0)return 1;
        if(n < 0 )return 0;
        if(dp[n][m]!=null) return dp[n][m];
        
        if(S.charAt(n) == T.charAt(m)){
            return  dp[n][m] = (solve(S.substring(0,n) , T,dp)%mod + solve(S.substring(0,n) , T.substring(0,m),dp)%mod)%mod;
        }else{
            return dp[n][m] = solve(S.substring(0,n),T,dp) %mod;
        }
        
        
    }
    
    
    
    
}