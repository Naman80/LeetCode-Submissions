class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int n  = q.length;
        
        int[] ans = new int[n];
        
        int sum = 0;
        
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                sum+=nums[i];
            }
        }
        
        for(int i = 0 ; i< n ; i++){
            
            int number = nums[q[i][1]] + q[i][0];
            
            if(nums[q[i][1]] % 2 ==0){
                sum -= nums[q[i][1]];
                if(number%2==0){
                    sum+=number;
                }
            }else{
                if(number%2==0){
                    sum+=number;
                }
            }
            nums[q[i][1]] = number;
            ans[i] = sum;
        }
        
        return ans;
        
    }
}