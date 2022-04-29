class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = 0;int j = n-1;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int mid = 0 ;
        while(i<=j){
            mid  =  i  + (j-i)/2;
            
            if(nums[mid]==target){
                ans[0] = mid;
                ans[1] = mid;
                break;
            }
            
            if(nums[mid] > target ) j = mid-1;
            
            else i  = mid+1;
        }
        
        if(ans[0]==-1) return ans;
        
        while(nums[i]!= target) i++;
        
        ans[0] = i;
        
        while(nums[j]!=target) j--;
        ans[1] = j;
        
        return ans;
         
    }
}