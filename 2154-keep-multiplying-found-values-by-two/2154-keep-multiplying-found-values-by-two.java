class Solution {
    public int findFinalValue(int[] nums, int o) {
        
        Arrays.sort(nums);
        int ans = o;
        
        for(int x : nums){
            if(x==ans){
                ans*=2;
            }
        }
        
        return ans;
       
    }
}