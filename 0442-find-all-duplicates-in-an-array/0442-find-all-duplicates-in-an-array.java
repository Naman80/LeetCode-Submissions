class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int i = 0;
        int n = nums.length;
        while(i < n ){
            
            
            while((nums[i] != i+1) && nums[nums[i]-1] != (nums[i])){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp -1] = temp;
            }
            i++;
            
            
        }
        
        List<Integer>ans = new ArrayList<>();
        
        for(int j = 0 ; j < n ; j ++){
            if(nums[j]!= j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
        
    }
}