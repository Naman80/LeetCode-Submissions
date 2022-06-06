class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> hs = new HashSet<>();
        
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        int l = trust.length;
        for(int i = 0 ; i <l;i++){
            adj.get(trust[i][0]).add(trust[i][1]);
            hs.add(trust[i][0]);
        }
        
        // System.out.print(adj);
        int[] indeg = new int[n+1];
        
        for(int i = 1 ;i <=n;i++){
            for(int x : adj.get(i)){
                indeg[x]++;
            }
        }
        
        for(int i = 1;i<=n;i++){
            if(indeg[i]==n-1 && !hs.contains(i))return i;
        }
        return -1;
    }
}