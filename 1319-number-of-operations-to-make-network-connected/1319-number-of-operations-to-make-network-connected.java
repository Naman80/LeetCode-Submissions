class Solution {
    public int makeConnected(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int edges = 0;
        for(int[] x : connections){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
            edges++;
        }
        boolean[] vis = new boolean[n];
        int compo = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                compo++;
                dfs(i,adj,vis);
            }
        }
        
        if(edges < n-1)return -1;
        return compo-1;
        
        
    }
    
    
    void dfs(int v ,  ArrayList<ArrayList<Integer>> adj ,boolean[] vis){
        vis[v] = true;
        for(int x : adj.get(v)){
            if(!vis[x]){
                dfs(x,adj,vis);
            }
        }
    }
}