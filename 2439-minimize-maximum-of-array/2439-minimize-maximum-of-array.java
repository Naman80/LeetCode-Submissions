class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0];
        for(int x : nums)max = Math.max(max , x);
        long ans = Long.MAX_VALUE;
        int lo = 0;
        int hi = max;
        int n = nums.length;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            // if(valid(mid , nums))
            if(!valid(mid , nums))lo=mid+1;
            else hi = mid-1;
        }
        return (int)lo;       
    }
    
       private static boolean valid(int mid, int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > (long)mid * (i+1)) return false;
        }
        return true;
    }
}