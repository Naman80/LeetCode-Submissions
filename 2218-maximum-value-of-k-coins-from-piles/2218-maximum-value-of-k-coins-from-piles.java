class Solution {
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
    
        int[][] dp = new int[piles.size()][k+1];
        for(int[] x:dp)Arrays.fill(x,-1);
        return solve(0,k,piles,dp);
    }
    
    
    int solve(int idx ,int k,List<List<Integer>> piles ,int[][] dp){
        
        if(idx==piles.size() || k==0)return 0;
        if(dp[idx][k]!= -1)return dp[idx][k];
        int np = solve(idx+1,k,piles,dp);
        int sum = 0;
        for(int i  = 0;i< Math.min(k,piles.get(idx).size());i++){
            sum+=piles.get(idx).get(i);
            np = Math.max(np,sum + solve(idx+1 , k - (i+1),piles,dp));
            
        }
        
        
        return dp[idx][k] = np;
        
        
        
    }
    
    
    
    
}