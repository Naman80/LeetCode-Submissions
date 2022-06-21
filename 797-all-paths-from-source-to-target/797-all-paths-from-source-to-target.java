class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0 ; i < n ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int  j = 0; j < graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        
        dfs(0,adj,vis,ans,new ArrayList<>());
        
        return ans;
        
        
    }
    
    
    void dfs(int v ,List<List<Integer>> adj, boolean[] vis,List<List<Integer>> ans,List<Integer> al){
        
        vis[v] = true;
        
        al.add(v);
        // System.out.println(al);
        if(v == adj.size()-1){
            ans.add(new ArrayList<>(al));
            // al.remove(al.size()-1);
            // vis[v] = false;
            // return;
        }
        
        for(int x : adj.get(v)){
            if(!vis[x]){
                dfs(x,adj,vis,ans,al);
            }
        }
        
        al.remove(al.size()-1);
        
        vis[v] = false;
        
    }
}