class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        
        for(int i = 0 ;i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i <n;i++){
            for(int j = 0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int com = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                com++;
                dfs(i,adj,vis);
            }
        }
        
        return com;
        
        
    }
    
    void dfs(int v, ArrayList<ArrayList<Integer>> adj ,boolean[] vis){
        vis[v] = true;
        
        
        for(int x:adj.get(v)){
            if(!vis[x]){
                dfs(x,adj,vis);
            }
        }
    }
}