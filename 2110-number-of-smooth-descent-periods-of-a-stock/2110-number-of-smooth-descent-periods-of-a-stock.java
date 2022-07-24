class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long ans = 0;
        long count = 1;
        int n = prices.length;
        
        int i = 0;
        int j = i+1;
        
        
        while(j < n){
            if(prices[j-1] - prices[j] == 1){
                j++;
                count++;
            }else{
                ans += (((count + 1) * count )/2);
                i = j;
                j++;
                count = 1;
            }
        }
         ans += (((count + 1) * count )/2);
        return ans;
        
    }
}