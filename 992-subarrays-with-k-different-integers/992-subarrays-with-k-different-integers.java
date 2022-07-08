class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return solve(nums,k) - solve(nums,k-1);
        
        
    }
    
    
    int solve(int[] nums, int k ){
        
        
        int ans = 0 ;
        
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int n = nums.length;
       int i = 0;int j =0 ;
        
        while(j < n){
            hm.putIfAbsent(nums[j],0);
            
            hm.put(nums[j] , hm.get(nums[j]) + 1);
            
            if(hm.size() >k){
                while(hm.size() > k){
                    hm.put(nums[i] , hm.get(nums[i])-1);
                    if(hm.get(nums[i])==0)hm.remove(nums[i]);
                    i++;
                }
            }
            
            ans+= j-i+1;
            j++;
            
            
            
        }
           
        return ans;
         
        
        
    }
}