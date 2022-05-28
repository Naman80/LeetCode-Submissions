class Solution {
    // public long maximumImportance(int n, int[][] roads) {
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     for(int i = 0;i<n;i++){
    //         adj.add(new ArrayList<Integer>());
    //     }
    //     for(int[] i :roads){
    //         adj.get(i[0]).add(i[1]);
    //         adj.get(i[1]).add(i[0]);
    //     }
    //     Collections.sort(adj,(a,b) -> a.size() - b.size());
    //     long ans = 0, x = 1;
    //     for(ArrayList<Integer> i : adj) ans +=  i.size() * (x++) ;
    //     return ans;
    // }
       public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        for(int road[] : roads){
            degree[road[0]]++; 
			degree[road[1]]++;
        }
        Arrays.sort(degree);
        long ans = 0, x = 1;
        for(long i : degree) ans +=  i * (x++) ;
        return ans;
    }
}