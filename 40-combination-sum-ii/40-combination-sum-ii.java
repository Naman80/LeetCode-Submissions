class Solution {
        List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);
        solve(0,0,target,c,new ArrayList<>());
        return ans;
    }
    
    void solve(int idx ,int sum ,int tar ,int[] arr , ArrayList<Integer> al){
        if(sum==tar){
            ans.add(new ArrayList<>(al));
            return ;
        }
        if(sum>tar)return;
        
        for(int i = idx ; i < arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]){continue;}
            al.add(arr[i]);
            sum+=arr[i];
            solve(i+1 ,sum ,tar,arr,al);
            sum-=arr[i];
            al.remove(al.size()-1);
        }
    }
}