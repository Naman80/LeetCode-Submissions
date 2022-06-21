class Solution {
//     int ans = 0;
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         int n = heights.length;
//         Integer[][][] dp = new Integer[n+1][bricks+1][ladders+1];
//         solve(1,heights,bricks,ladders,dp);
//         return ans-1;
//     }
    
    
//     public void solve(int idx , int[] h, int b, int l,Integer[][][] dp){
//         if(idx>=h.length){
//             dp[idx][b][l] = Math.max(ans,idx);
//             ans = dp[idx][b][l];
//             return;
//         }
//         if(dp[idx][b][l] != null){
//             ans = dp[idx][b][l];
//             return;
//         }
//         if(h[idx] <= h[idx-1]){
//             solve(idx+1,h,b,l,dp);
//         }else{
//             if(h[idx] - h[idx-1] <= b){
//                 solve(idx+1,h,b - (h[idx]-h[idx-1]),l,dp);
//             }
//             if(l>0){
//                 solve(idx+1,h,b,l-1,dp);
//             }
//         }
//         dp[idx][b][l] = Math.max(ans,idx);
//         ans = dp[idx][b][l];
//     }
    
    public int furthestBuilding(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            int d = A[i + 1] - A[i];
            if (d > 0)
                pq.add(d);
            if (pq.size() > ladders)
                bricks -= pq.poll();
            if (bricks < 0)
                return i;
        }
        return A.length - 1;
    }
}