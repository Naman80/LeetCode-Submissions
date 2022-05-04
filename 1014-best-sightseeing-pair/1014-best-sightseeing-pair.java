class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        
        int n = nums.length;
        int prev = nums[0];
         int max = Integer.MIN_VALUE;
        for(int i = 1;i<n;i++){
            max = Math.max(max,prev + (nums[i]-i));
            prev = Math.max(prev,nums[i]+i);
        }
       
        return max;
        
        
    }
}