class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;    
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0 ;i<n;i++){
            if(color[i]==-1){
                if(!solve(i,color,adj))return false;
            }
        }
        
        return true;
        
    }
    
    boolean solve(int v , int[] color , ArrayList<ArrayList<Integer>> adj ){
        if(color[v]==-1)color[v] = 1;
        for(int x : adj.get(v)){
            if(color[x]==-1){
                color[x] = 1 - color[v];
                if(!solve(x , color,adj))return false;
            }else if(color[x]==color[v])return false;       
        }
        return true;
    }
}