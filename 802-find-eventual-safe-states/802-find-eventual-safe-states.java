class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ;j < graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> safe = new HashSet<>();
        for(int i = 0 ; i < n ;i++){
            if(adj.get(i).size()==0){
                safe.add(i);
                ans.add(i);
                vis[i]=true;
            }
        }
        
        for(int i = 0 ;i <n;i++){
            if(!vis[i]){
                int temp = dfs(i,adj,vis,ans,safe);
            }
        }
        Collections.sort(ans);
        return ans;
        
    }
    
    
    int dfs(int v ,ArrayList<ArrayList<Integer>> adj ,boolean[] vis ,List<Integer> ans , HashSet<Integer> safe){
        
        //base Cases
        
        if(vis[v] && !safe.contains(v))return 0;
        if(safe.contains(v))return 1;
        // if(adj.get(v).size()==0)return 1;
        
        int count = 0;
        
        vis[v] = true;
        
        for(int x : adj.get(v)){
            
            count+= dfs(x , adj,vis,ans,safe);    
        }
        
        if(count==adj.get(v).size()){
            ans.add(v);
            safe.add(v);
            return 1;
        }else return 0;
        
        
    }
}