class Solution {
    public int[] findOrder(int num, int[][] pre) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < num;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] x : pre){
            adj.get(x[1]).add(x[0]);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[num];
        boolean[] rec = new boolean[num];
        for(int i = 0 ; i < num;i++){
            if(!vis[i]){
                if(dfs(i,adj,vis,st,rec))return new int[0];
            }
        }
        
        int[] ans = new int[num];
        
        for(int i = 0 ;i<num;i++){
            ans[i] = st.pop();
        }
        
        return ans;
        
    }
    
    
    boolean dfs(int v , ArrayList<ArrayList<Integer>> adj,boolean[] vis, Stack<Integer> st ,boolean[] rec){
        vis[v] = true;
        rec[v] = true;
        for(int x:adj.get(v)){
            if(!vis[x]){
                if(dfs(x,adj,vis,st,rec))return true;
            }else if(rec[x])return true;
        }
        
        rec[v] = false;
        st.push(v);
        
        return false;
    }
    
    
    
}