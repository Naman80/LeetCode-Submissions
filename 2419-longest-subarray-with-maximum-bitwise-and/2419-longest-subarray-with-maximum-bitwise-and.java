class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for(int x : nums){
            max = Math.max(max , x);
        }
        int ans = 1;
        int i = 0;
        int j = 0;
        while(j < n){
            while(i < n && j < n && nums[j]!=max){
                j++;
            }
            i = j;
            while(j < n && nums[j]==max){
                j++;
            }            
            ans = Math.max(ans , j - i);
        }
        ans = Math.max(ans , j - i);
        return ans;
    }
}