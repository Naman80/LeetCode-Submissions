// MY SOLUTION -> NOT SO CLEAR AND TO THE POINT

// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         int n = graph.length;
        
//         for(int i = 0 ; i < n ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int i = 0 ; i < n ;i++){
//             for(int j = 0 ;j < graph[i].length;j++){
//                 adj.get(i).add(graph[i][j]);
//             }
//         }
        
//         boolean[] vis = new boolean[n];
//         ArrayList<Integer> ans = new ArrayList<>();
//         HashSet<Integer> safe = new HashSet<>();
//         for(int i = 0 ; i < n ;i++){
//             if(adj.get(i).size()==0){
//                 safe.add(i);
//                 ans.add(i);
//                 vis[i]=true;
//             }
//         }
        
//         for(int i = 0 ;i <n;i++){
//             if(!vis[i]){
//                 int temp = dfs(i,adj,vis,ans,safe);
//             }
//         }
//         Collections.sort(ans);
//         return ans;
        
//     }
    
    
//     int dfs(int v ,ArrayList<ArrayList<Integer>> adj ,boolean[] vis ,List<Integer> ans , HashSet<Integer> safe){
        
//         //base Cases
        
//         if(vis[v] && !safe.contains(v))return 0;
//         if(safe.contains(v))return 1;
//         int count = 0;        
//         vis[v] = true;
//         for(int x : adj.get(v)){
//             count+= dfs(x , adj,vis,ans,safe);    
//         }
//         if(count==adj.get(v).size()){
//             ans.add(v);
//             safe.add(v);
//             return 1;
//         }else return 0;
        
        
//     }
// }



// MANY SOLUTION EXIST FOR THIS QUESTION

// HERE WE JUST WANT TO CHECK IF CYCLE IS PRESENT AT THAT NODE OF NOT


// NODE COLORING METHOD 
// 
 ////////-----------------------------//////////

// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int N = graph.length;
//         int[] color = new int[N];
//         List<Integer> ans = new ArrayList();

//         for (int i = 0; i < N; ++i)
//             if (dfs(i, color, graph))
//                 ans.add(i);
//         return ans;
//     }

//     // colors: WHITE 0, GRAY 1, BLACK 2;
//     public boolean dfs(int node, int[] color, int[][] graph) {
//         if (color[node] > 0)
//             return color[node] == 2;

//         color[node] = 1;
//         for (int nei: graph[node]) {
//             if (color[node] == 2)
//                 continue;
//             if (color[nei] == 1 || !dfs(nei, color, graph))
//                 return false;
//         }

//         color[node] = 2;
//         return true;
//     }
// }


// ------------------------------------------------------------------------------------
class Solution{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] vis = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
           
            if(vis[i]==1){
                res.add(i);
                continue;
            }
            if(dfs(graph, i, vis) == 1)
                res.add(i);
 
        }
        return res;
    }

    private int dfs(int[][] adj, int src, int[] vis){
        if(vis[src] != 0) return vis[src];//0 represents unvisited node

        vis[src] = -1;//-1 represents current search

        for(int neighbor : adj[src])
            if(dfs(adj, neighbor, vis) == -1) 
                return -1;//unsafe node return immediately 

        return vis[src] = 1;//1 represents safe node
    }
}
