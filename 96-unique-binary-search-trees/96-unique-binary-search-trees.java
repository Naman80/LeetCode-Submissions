class Solution {
    public int numTrees(int n) {
        
        // CATALAN NUMBERS
        
        // C0 - 1
        // C1 - 1
        // C2 -> C0*C1 + C1+C0 --> 2
        // C3 -> C0C2 + C1C1 + C2C0 --> 5
        // C4 -> C0C3 + C1C2 + C2C1 + C3C0 --> 5 + 2 + 2 + 5 -> 14
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i < n+1;i++){
            int num = 0;
            for(int j = 0 ,k = i-1; j < i;j++,k--){
                num+= dp[j]*dp[k];
            }
            dp[i] = num;   
        }
        return dp[n];
    }
}