class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for( int i = 0 ; i < n ; i++ )
        {
             temp+=nums[i];
            max = Math.max(max,temp);
            if(temp<=0){
             temp = 0;   
            }
            
        }
        
        return max;
        
    }
    
}