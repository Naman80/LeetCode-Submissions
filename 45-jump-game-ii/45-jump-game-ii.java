class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int far = 0 ;
        int cmax = 0;
        int jump = 0;
        
        for(int i =0;i<n-1;i++){
            far = Math.max(far,i+nums[i]);
            
            if(i==cmax){
                jump++;cmax = far;
            }
        }
        
        return jump;
        
    }
    
    
}