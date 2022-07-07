class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        
        int neg = 0;
        // int pos = 0;
        
        int lastz = -1;
        int max1 = 0;
        for(int i = 0 ; i<n;i++){
            if(nums[i] < 0)neg++;
            // if(nums[i] > 0)pos++;
            if(nums[i] == 0){
                neg =0;
                lastz = i;
            }else{
                if(neg%2 == 0){
                    max1 = Math.max(max1 , i - lastz);
                }
            }
        }
        
        
        neg = 0;
        lastz = n;
        int max2 =0;
        for(int i = n-1 ; i>=0;i--){
            
            if(nums[i] < 0)neg++;
            // if(nums[i] > 0)pos++;
            if(nums[i] == 0){
                lastz = i;
                neg = 0;
            }else{
                if(neg%2 == 0){
                    max2 = Math.max(max2 , lastz - i);
                }
            }
            
            
        }
        
        return (int)Math.max(max1,max2);
        
    }
}