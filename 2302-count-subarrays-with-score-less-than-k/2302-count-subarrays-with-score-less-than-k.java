class Solution {
    public long countSubarrays(int[] nums, long k) {
        
       int i = 0 ; int j = 0 ;
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        while(j < n){
            sum += nums[j];
            
            while(sum * (j-i+1) >=k){
                sum-=nums[i];
                i++;
            }
            
            ans+= j-i+1;
            j++;
            
        }
        
        return ans;
        
    }
}