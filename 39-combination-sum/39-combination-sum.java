class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] c, int target) {
        
        solve(0,c,0,target,new ArrayList<>());
        return ans;
        
    }
    
    public void solve(int idx,int[] c ,int sum,int target,List<Integer> temp){
        
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        if(sum>target || idx >= c.length)return ;
        
        
        temp.add(c[idx]);
        sum+=c[idx];
        
        solve(idx,c,sum,target,temp);
        
        sum-=c[idx];
        temp.remove(temp.size()-1);
        solve(idx+1,c,sum,target,temp);
        
        
        
    }
}