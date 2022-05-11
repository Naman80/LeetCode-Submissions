class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[6][n+1];
        for(int i = 0;i<6;i++){
            for(int j = 0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }
        char[] vo = {'a','e','i','o','u'};
        return solve(0,vo,n,"",dp);
    }
    
    public int solve(int idx,char[] vo, int n,String p,int[][]dp){
        if(p.length()==n)return 1;
        if(idx==vo.length) return 0;
        if(dp[idx][p.length()] != -1)return dp[idx][p.length()];
        int pick = solve(idx,vo,n,p+vo[idx],dp);
        int np = solve(idx+1,vo,n,p,dp);
        return dp[idx][p.length()] = np+pick;
    }
    
    
}