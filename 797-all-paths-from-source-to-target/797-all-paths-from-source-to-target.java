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
        dfs(0,adj,ans,new ArrayList<>());
        return ans;   
    }
    
    
    void dfs(int v ,List<List<Integer>> adj,List<List<Integer>> ans,List<Integer> al){
     
        al.add(v);
        if(v == adj.size()-1){
            ans.add(new ArrayList<>(al));
        }       
        for(int x : adj.get(v)){
            
                dfs(x,adj,ans,al);
            
        }
        al.remove(al.size()-1);
       
    }
}