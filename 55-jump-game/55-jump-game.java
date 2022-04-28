class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        if(n==1) return true;
        if(nums[0]==0) return false;
        
        int max = nums[0];
        
        for(int i = 0;i<n;i++){
            max--;
            max = Math.max(max,nums[i]);
            if(max==0 && i!=n-1) return false;
        }
        
        return true;
    }
}