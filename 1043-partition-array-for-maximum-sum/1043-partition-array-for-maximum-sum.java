class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return solve(0 , k , arr , arr.length , dp);
        // int[][] dp = new int[n][k];
        // for(int i = 0 ; i < )
        // for(int i = n-1 ; i >=0 ; i--){

        // }


    }
    public int solve(int idx , int k , int[] arr , int n , Integer[] dp){
        if(idx>=n)return 0;
        if(dp[idx]!=null)return dp[idx];
        int max = arr[idx];
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            if(idx+i<n){
                max = Math.max(max , arr[idx+i]);
                sum = Math.max(sum , (max*(i+1)) + solve(idx+i+1 , k , arr , n, dp));
            }
        }
        // System.out.println(sum);
        return dp[idx] = sum;
    }
}