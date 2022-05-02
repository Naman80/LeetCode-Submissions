class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            
            while(i<n && nums[i]%2==0){
                i++;
            }
            
            while(j>=0 && nums[j]%2==1){
                j--;
            }
            
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
            }
            
        }
        
        return nums;
    }
}