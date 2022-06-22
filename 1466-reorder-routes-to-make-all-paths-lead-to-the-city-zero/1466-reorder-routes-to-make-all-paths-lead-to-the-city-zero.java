class Solution {
    int ans = 0;
    // int[] parent;
    public int minReorder(int n, int[][] c) {
       ArrayList<ArrayList<Integer[]>> adj = new ArrayList<>(); 
        for(int i = 0 ; i<n;i++){
            adj.add(new ArrayList<>());
        }   
        for(int[] x : c){
            adj.get(x[0]).add(new Integer[]{x[1],1});
            adj.get(x[1]).add(new Integer[]{x[0],0});
        }        
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
        return ans;
    }
    void dfs(int v , ArrayList<ArrayList<Integer[]>> adj , boolean[] vis){
        vis[v] = true;
        for(Integer[] x : adj.get(v)){
            if(!vis[x[0]]){
                if(x[1]==1)ans++;
                dfs(x[0],adj,vis);
            }
        }   
    }
}