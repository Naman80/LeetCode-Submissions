class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int tempsum = nums[0] + nums[1] + nums[nums.length - 1];
        
        
        for(int i = 0 ; i < n-2;i++){
            int start = i+1;
            int end = n-1;
            
            while(start < end){
                int runsum = nums[i] + nums[start] + nums[end];
                
                
                if(runsum > target){
                    end--;
                }else{
                    start++;
                }
                
                if(Math.abs(runsum - target) < Math.abs(tempsum - target)){
                    tempsum = runsum;
                }
                
                
            }
        }
        
        return tempsum;
        
        
        
        
    }
}