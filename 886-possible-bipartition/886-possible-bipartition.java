class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        // bipartite color check two colours
        // m - colour is backtracting question not two colour
        
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ;i < n ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] x : dislikes){
            
            int x1 = x[0];
            int x2 = x[1];
            
            adj.get(x1 - 1).add(x2 - 1);
            adj.get(x2 - 1).add(x1 - 1);
            
        }
        
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        
        for(int i = 0 ; i < n;i++){
            if(!check(i,adj,color))return false;
        }
        
        return true;
        
        
    }
    
    boolean check(int v , ArrayList<ArrayList<Integer>> adj , int[] color){
        
        if(color[v] == -1)color[v] = 1;
        
        for(int x : adj.get(v)){
            
            if(color[x] == -1){
                color[x] = color[v] - 1;
                if(!check(x,adj,color))return false;
            }else if(color[x] == color[v])return false;
            
        }
        
        return true;
        
    }
}