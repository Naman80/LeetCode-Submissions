class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        Integer[][] dp = new Integer[n+1][n+1];
        return solve(0,-1,nums,dp);
    }
    
    
    int solve(int idx,int prev,int[]nums,Integer[][] dp){
        
        if(idx>=nums.length)return 0;
        if(prev != -1 && dp[idx][prev] != null)return dp[idx][prev];
        int np = solve(idx+1,prev,nums,dp);
        
        int pick = 0;
        
        if(prev == -1 || nums[idx] > nums[prev]){
            pick  = 1 + solve(idx+1,idx,nums,dp); 
        }
        if(prev==-1) return Math.max(pick,np);
        return dp[idx][prev] = Math.max(pick,np);
        
    }
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
    
    

     // public int lengthOfLIS(int[] nums) {
     //     int n = nums.length;
     //     ArrayList<Integer> al = new ArrayList<>();
     //     // al.add(nums[0]);
     //    int ans= 0;
     //     for(int i = 0;i<n;i++){
     //         if( al.isEmpty() || nums[i] > al.get(al.size()-1) ){
     //             al.add(nums[i]);
     //             ans++;
     //         }else{
     //             int pos =  Collections.binarySearch(al,nums[i]);
     //             if(pos<0){
     //                 pos = Math.abs(pos+1);
     //                    al.set(pos,nums[i]);
     //             }
     //         }  
     //     }
     //     return ans;
     // }
}