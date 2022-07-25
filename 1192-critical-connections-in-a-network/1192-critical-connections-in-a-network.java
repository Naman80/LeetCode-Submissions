class Solution {
    // TARJAN'S ALGORITHM --> ALSO USED TO FIND BRIGDES AND ARTICULATION POINTS
    ArrayList<ArrayList<Integer>> adj1;
    Stack<Integer> st = new Stack<>();
    boolean[] onStack;
    int[] id ;
    int[] low ;
    int idx = 0;
    
    void dfs(int at , int parent){
        st.push(at);
        id[at] = low[at] = idx++;
        onStack[at] = true;
        for(int to : adj1.get(at)){
            if(to==parent)continue;
            if(id[to]==-1)dfs(to,at);
            if(onStack[to]) low[at] = Math.min(low[to] , low[at]);
        }
        if(id[at] == low[at]){   
            while(true){
                int out = st.pop();
                low[out] = id[at];
                onStack[out] = false;
                if(out==at)break;
            }
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        id = new int[n];
        Arrays.fill(id,-1);
        low = new int[n];
        onStack = new boolean[n];
        adj1 = new ArrayList<>();
        for(int i =0 ;i<n;i++){
            adj1.add(new ArrayList<>());
        }
        
        for(List<Integer> x : connections){
            int u = x.get(0);
            int v = x.get(1);
            adj1.get(v).add(u);
            adj1.get(u).add(v);
        }
        
        for(int i = 0 ;i<n;i++){
            if(id[i]==-1){
                dfs(i,-1);
            }
        }
        
        // for(int i =0 ;i<n;i++){
        //     System.out.print(low[i] + " ");
        // }
        List<List<Integer>> ans = new ArrayList<>();
         for(List<Integer> x : connections){
            int u = x.get(0);
            int v = x.get(1);
            
             if(low[u] != low[v]){
                 List<Integer> temp = new ArrayList<>();
                 temp.add(u);
                 temp.add(v);
                 ans.add(temp);
             }
         
         }
        
        return ans;
        
    }
}