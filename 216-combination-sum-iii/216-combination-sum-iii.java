class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        solve(0,nums,new ArrayList<>(),0,n,k);
        return ans;
    }
    
    public void solve(int idx,int[] nums,List<Integer> temp,int sum,int n,int k){
         if(sum==n && temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx >=nums.length || sum > n || temp.size() > k)return;
       
        
        temp.add(nums[idx]);
        sum+= nums[idx];
        solve(idx+1,nums,temp,sum,n,k);
        sum-= nums[idx];
        temp.remove(temp.size()-1);
        solve(idx+1,nums,temp,sum,n,k);
        
    }
    
    
}