class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < manager.length;i++){
            if(manager[i]==-1)continue;
            adj.get(manager[i]).add(i);
        }   
        return dfs(headID , adj,informTime);
    }
    int dfs(int v , ArrayList<ArrayList<Integer>> adj , int[] informTime){
        int ans = 0;   
        for(int x : adj.get(v)){
            int sum = informTime[v] + dfs(x , adj , informTime);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}