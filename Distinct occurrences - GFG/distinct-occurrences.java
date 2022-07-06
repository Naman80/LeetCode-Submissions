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
        Integer[][] dp = new Integer[n][m];
        
        return solve(S,T ,dp);
      
        
	    
	
    }
    
    int solve(String S , String T ,Integer[][] dp){
        
        
        int n = S.length()-1;
        int m = T.length()-1;
        
        if(m<0)return 1;
        if(n < 0 )return 0;
        if(dp[n][m]!=null)return dp[n][m];
        
        if(S.charAt(n) == T.charAt(m)){
            return  dp[n][m] = (solve(S.substring(0,n) , T,dp)%mod + solve(S.substring(0,n) , T.substring(0,m),dp)%mod)%mod;
        }else{
            return dp[n][m] = solve(S.substring(0,n),T,dp) %mod;
        }
        
        
    }
    
    
    
    
}