class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     int ans  = 0;
    //     for(int i = 0;i<n;i++){
    //         int max = 0;
    //         for(int j = 0;j<i;j++){
    //             if(nums[i] > nums[j]){
    //                 max = Math.max(dp[j],max);
    //             }   
    //         }  
    //         dp[i] = max+1;
    //         ans = Math.max(ans,dp[i]);
    //     }
    //     return ans;
    // }
    
    
     public int lengthOfLIS(int[] nums) {
         
         int n = nums.length;
         
         ArrayList<Integer> al = new ArrayList<>();
         
         al.add(nums[0]);
         
         for(int i = 1;i<n;i++){
             
             if(nums[i] > al.get(al.size()-1)){
                 al.add(nums[i]);
             }else{
                 
                 int pos =  Collections.binarySearch(al,nums[i]);
                 if(pos<0){
                     pos = Math.abs(pos+1);
                        al.set(pos,nums[i]);
                 }
                
                    
             }
             
         }
         
         return al.size();
         
     }
}