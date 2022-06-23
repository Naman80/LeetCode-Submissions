class Solution {
    public boolean canFinish(int num, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i =0;i<num;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] x : pre){
            adj.get(x[1]).add(x[0]);
        }
       boolean[] vis = new boolean[num];
        boolean[] rec = new boolean[num];
        for(int i = 0 ;i<num;i++){
            if(!vis[i]){
                if(dfs(i,adj,rec,vis))return false;}
            
        }
        
        return true;
        
    }
    
    
   public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean[] rec,boolean[] vis){
       vis[v] = true;
       rec[v] = true;
       
       for(int x : adj.get(v)){
           if(!vis[x]){
               if(dfs(x,adj,rec,vis))return true;
           }else if(rec[x]) return true;
       }
       rec[v] = false;
       
       return false;
       
   }
    
    
    
}