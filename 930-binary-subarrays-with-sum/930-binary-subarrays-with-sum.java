class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int k = atmostgoalK(nums , goal);
        if(goal == 0)return k;
        int k1 = atmostgoalK(nums,goal-1);
        // System.out.println(k);
        // System.out.println(k1);
        return k - k1;
    }
    
    
    int atmostgoalK(int[] nums , int k){
        
        int i = 0 ; int j = 0 ;int n = nums.length;
        int ans = 0;
        int sum = 0;
        
        while(j < n){
            sum+=nums[j];
            while(i < n && sum > k){
                sum-=nums[i];
                i++;
            }
            ans += j - i +1;
            j++;
        }
        return ans;
    }
}