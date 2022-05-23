class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Integer[][][] dp = new Integer[len][m+1][n+1];
        return solve(0,m,n,strs,dp);
    }
    
    int solve(int idx, int m , int n, String[] arr,Integer[][][] dp){
        if(m<0 || n < 0)return 0;
        if(idx==arr.length)return 0;
        if(dp[idx][m][n] != null)return dp[idx][m][n];
        String s = arr[idx];
        int dm = m;int dn = n;
        for(int  i = 0 ;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='1') dn--;
            else dm--;
        }
        int p = 0;
        if(dm>=0 && dn>=0){
             p = 1 + solve(idx+1,dm,dn,arr,dp);
        }
        int np = solve(idx+1,m,n,arr,dp);
        return dp[idx][m][n] = Math.max(p,np);
    }
}