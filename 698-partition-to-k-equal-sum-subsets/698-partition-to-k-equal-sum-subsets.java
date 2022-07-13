class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        
        int sum = 0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%k!=0)return false;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i <= n/2;i++){
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        int[] arr = new int[k];
        return solve(0,nums,arr,k,sum/k);
    }
    boolean solve(int start,int[] nums,int[] arr,int k,int sum){
        if(start>=nums.length){
            for(int i = 1 ;i<k;i++){
                if(arr[i-1] != arr[i])return false;
            }
            return true;   
        }
        for(int i = 0 ;i<k;i++){
            if(i>0 && arr[i-1]==0)break;
            arr[i]+=nums[start];
            if(arr[i]<= sum){
                 if(solve(start+1, nums,arr,k,sum))return true;
            }
            arr[i]-=nums[start];
        }
        return false;
    }
    
    
    
}