class Solution {
    public int[] twoSum(int[] nums, int tar) {
        int[] ans = new int[2];
        int n = nums.length;
        for(int i = 0 ;i<n-1;i++){
            int subtar = tar - nums[i];
            // System.out.println(subtar);
            // nums[i] = Integer.MAX_VALUE;
            int in = binarySearch(i+1,n-1,nums,subtar);
            
            // System.out.println(in);
            if(in>=0){
                ans[0] = i+1;
                ans[1] = in+1;
                break;
            }
        }
        return ans;
    }
    
    int binarySearch(int s ,int e , int[] nums,int find){
        
       
        
        while(s<=e){
             int mid = s + (e-s)/2;
            if(nums[mid] == find)return mid;
            else if(nums[mid] > find) e = mid-1;
            else s = mid+1;
            
        }
        
        return -1;
        
    }
}