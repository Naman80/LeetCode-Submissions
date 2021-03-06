class Solution {
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] p) {
        int n = p.length;
        parent = new int[n];
        for(int i = 0 ; i < n;i++){parent[i] = i;}
        rank = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);al.add(j);
                int dis = Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]);
                al.add(dis);
                adj.add(al);
            }
        }
        int usedegdes = 0;
        Collections.sort(adj,Comparator.comparingInt((a)->a.get(2)));
        int sum = 0;
        for(ArrayList<Integer> x : adj){
            if(usedegdes < n-1 && find(x.get(0)) != find(x.get(1))){
                sum+=x.get(2);
                union(x.get(0),x.get(1));
                usedegdes++;
                if(usedegdes==n-1)break;
            }
        }
        return sum;
    }
    int find(int x){
        if(parent[x] == x)return x;   
        return parent[x] = find(parent[x]);
    }
    void union(int u , int v){   
        u = find(u);
        v = find(v);
        if(u!=v){
            if(rank[u] < rank[v]){
                parent[u] = v;
            }else if(rank[v] < rank[u]){
                parent[v]  = u;
            }else{
                parent[v] = u;
                rank[u]++;
            }   
        }   
    }
}