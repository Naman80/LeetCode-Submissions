// class Solution {
//     public long getDescentPeriods(int[] prices) {
        
//         long ans = 0;
//         long count = 1;
//         int n = prices.length;
//         int i = 0;
//         int j = i+1;  
//         while(j < n){
//             if(prices[j-1] - prices[j] == 1){
//                 j++;
//                 count++;
//             }else{
//                 ans += (((count + 1) * count )/2);
//                 i = j;
//                 j++;
//                 count = 1;
//             }
//         }
//         ans += (((count + 1) * count )/2);
//         return ans;
//     }
// }


// class Solution {
//     public long getDescentPeriods(int[] prices) {
//         long dp[] = new long[prices.length];
//         dp[0] = 1;
//         long ans = 1;
//         for(int i = 1; i < prices.length; i ++) {
//             if(prices[i] == prices[i - 1] - 1) {
//                 dp[i] = dp[i - 1] + 1;
//             } else {
//                 dp[i] = 1;
//             }
//             ans += dp[i];
//         }
//         return ans;
//     }
// }

class Solution {
    public long getDescentPeriods(int[] prices) {
        long dp = 1;
        long ans = 1;
        for(int i = 1; i < prices.length; i ++) {
            if(prices[i] == prices[i - 1] - 1) {
                dp ++;
            } else {
                dp = 1;
            }
            ans += dp;
        }
        return ans;
    }
}