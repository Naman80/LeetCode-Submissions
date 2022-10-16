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
            long carry  = 0;
            long tempmax = 0;
            for(int i = n-1 ; i >=0;i--){
                long temp = nums[i];
                // temp+=carry;
                if(temp >=mid){
                    carry += temp-mid;
                    temp = mid;
                }else{
                    long foo = temp;
                    temp +=Math.min(carry , mid - temp);
                    carry -= Math.min(carry , mid - foo);
                   
                }
                tempmax = Math.max(tempmax , temp);
                if(i==0){temp+= carry ; tempmax = Math.max(tempmax , temp);}
                // System.out.println(temp + " " + carry);
            }
            // System.out.println();
            
            if(tempmax == mid)ans = Math.min(ans , mid);
            if(tempmax > mid)lo=mid+1;
            else hi = mid-1;
        }
        return (int)ans;
        
    }
}
// 32/3
// 31/4
// 4,7,2,2,9,19,16,0,3,15
    
// 6 5 8 8 8 8 16 6 6 6
// 8 8 8 8 8 3 16 6 6 6
// 8 8 8 8 8 10 9 6 6 6    
// 8 8 8 8 9 9 9 6 6 6    
