class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 )return 0;
        Arrays.sort(nums);
        
        int ans = 0;
        
        int temp = 1;
        
        for(int i = 1 ; i < nums.length;i++){
            if(nums[i] == nums[i-1])continue;
            System.out.print(nums[i] + " ");
            if(nums[i-1] +1 == nums[i]){
                temp++;
            }else{
                ans = Math.max(ans,temp);
                temp = 1;
            }
            
        }
        ans = Math.max(ans,temp);
        return ans;
    }
}