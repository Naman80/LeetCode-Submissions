class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i =1 ; i < n  ; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        int ans = -1;
        for(int i = 0 ; i < n ; i++){
            if(i>0){
                if(sum[n-1] - sum[i] == sum[i-1]){ans=i;break;}
            }else{
                if(sum[n-1] - sum[i] == 0){ans=0;break;}
            }
        }
        return ans;
    }
}