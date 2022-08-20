// class Solution {
//     // HashMap<Long , Integer> map = new HashMap<>();
//     public int minRefuelStops(int target, int fuel, int[][] stations) {
        
        
//         int n = stations.length;
//         PriorityQueue<Pair> temp = new PriorityQueue<>();
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         int count = 0;
//         long sumfuel = fuel;
//         int i = 0;
//         for(i = 0 ; i < n ; i++){
//             if(target<= sumfuel)break;
//             if(stations[i][0] <= sumfuel){
//                 pq.add(new Pair(stations[i][0] , stations[i][1]));
//             }else{
//                 if(pq.size()==0)break;
//                 // System.out.print("bef"+" "+sumfuel + " aft +");
//                     Pair out = pq.poll();
//                     sumfuel+=out.fuel;
//                     count++;
//                     i--;
//                 // System.out.println( out.fuel+ " "+sumfuel);
//                 while(pq.size()!=0){
//                     Pair out2 = pq.poll();
//                     temp.add(out2);
//                 }
//             }
            
//         }
        
//         for(int j = i ; j < n ; j++){
//             temp.add(new Pair(stations[j][0] , stations[j][1]));
//         }
        
//         while(temp.size()!= 0 && target > sumfuel){
//             Pair out = temp.poll();
//             sumfuel+=out.fuel;
//             count++;
//         }
        
//         if(sumfuel < target)return -1;
//         return count;
        
        
        
        
//     }
    
    
    
// //     public int solve(int idx , long fuel , int target , int[][] stations ){
        
// //         if(fuel >= target){
// //             return 0;
// //         }
// //         if(idx >= stations.length){
// //             return Integer.MAX_VALUE - 501;
// //         }
// //         // if(dp[idx][fuel] != null)return dp[idx][fuel];
// //         if(map.containsKey(fuel))return map.get(fuel);
// //         if(fuel>= stations[idx][0]){
// //             fuel += stations[idx][1];
// //             int pick = 1 + solve(idx+1 , fuel, target , stations);
// //             fuel -= stations[idx][1];
// //             int notpick = solve(idx+1 , fuel , target , stations);  
// //             if(map.containsKey(fuel)){
// //                 int temp = map.get(fuel);
// //                 map.put(fuel , Math.min(temp , Math.min(pick , notpick)));
// //             }else{
// //                 map.put(fuel , Math.min(pick , notpick));
// //             }
// //             return map.get(fuel);
// //             // return dp[idx][fuel] = Math.min(pick , notpick);
// //         }else{
// //             map.put(fuel, Integer.MAX_VALUE - 501);
// //             return map.get(fuel);
// //         }    
// //     }
// }

// class Pair implements Comparable<Pair>{
    
//     int pos;
//     int fuel;
    
//     Pair(int pos , int fuel){
//         this.pos = pos;
//         this.fuel = fuel;
//     }
    
//     @Override
//     public int compareTo(Pair o){
//         return o.fuel - this.fuel;
//     }
// }

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}