class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int totSum=0;
    
    for(int i=0; i<n;i++){
        totSum+= arr[i];
    }
    
    if (totSum%2==1) return false;
    
    else{
        int k = totSum/2;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return subsetSumUtil(n-1,k,arr,dp);
    } 
        // int k  = 2;
        //  int sum = 0;
        // for(int x:nums){
        //     sum+=x;
        // }
        // if(sum%k!=0)return false;
        // int[] arr = new int[2];
        // boolean[][] dp = new boolean[nums.length+1][(sum/k)+1];
        // return solve(0,nums,0,sum/k,dp);
    }
    
    static boolean subsetSumUtil(int ind, int target,int arr[],int[][] dp){
    if(target==0)
        return true;
    
    if(ind == 0)
        return arr[0] == target;
    
    if(dp[ind][target]!=-1)
        return dp[ind][target]==0?false:true;
        
    boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);
    
    boolean taken = false;
    if(arr[ind]<=target)
        taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTaken||taken?1:0;
    return notTaken||taken;
}
    // boolean solve(int idx,int[] nums,int csum,int sum,boolean[][] dp){
    //     if(csum>sum)return false;
    //     if(csum==sum)return true;
    //     if(idx>=nums.length)return false;
    //     // if(dp[idx][csum])return dp[idx][csum];
    //     if(solve(idx+1,nums,csum+nums[idx],sum,dp))return true;
    //    if(solve(idx+1,nums,csum,sum,dp))return true;
    //     return false;
    //     // return dp[idx][csum] = opt1||opt2;
    // }
    
//     boolean solve(int start,int[] arr,int[] nums,int k){
//         if(start>= nums.length){
//             for(int i = 1 ; i < k ; i++)
//             {
//                 if(arr[i-1]!=arr[i])return false;
//             }            
//             return true;
//         }
//         for(int i = 0 ; i< k;i++){
//             if(i>0 && arr[i-1]==0)break;
//             arr[i]+=nums[start];
//             if(solve(start+1,arr,nums,k))return true;
//             arr[i]-=nums[start];
            
//         }
        
//         return false;
        
//     }
    
    // boolean solve(int start,int[] nums,int[] arr,int k,int sum){
    //     if(start>=nums.length){
    //         for(int i = 1 ;i<k;i++){
    //             if(arr[i-1] != arr[i])return false;
    //         }
    //         return true;   
    //     }
    //     for(int i = 0 ;i<k;i++){
    //         if(i>0 && arr[i-1]==0)break;
    //         arr[i]+=nums[start];
    //         if(arr[i]<= sum){
    //              if(solve(start+1, nums,arr,k,sum))return true;
    //         }
    //         arr[i]-=nums[start];
    //     }
    //     return false;
    // }
}