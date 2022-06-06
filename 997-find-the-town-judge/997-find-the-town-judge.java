class Solution {
    public int findJudge(int N, int[][] trust) {
    
        // HashSet<Integer> hs = new HashSet<>();
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // int l = trust.length;
        // if(l==0 && n==1)return 1;
        // for(int i = 0 ; i <l;i++){
        //     hs.add(trust[i][0]);
        //     hm.putIfAbsent(trust[i][1],0);
        //     hm.put(trust[i][1] , hm.get(trust[i][1]) + 1);
        // }
        // for(int i = 1;i<=n;i++){
        //     if(hm.containsKey(i) && hm.get(i) == n-1 && !hs.contains(i))return i;
        // }
        // return -1;
 
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
    
}