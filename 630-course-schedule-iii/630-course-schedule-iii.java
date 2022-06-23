// // class Solution {
// //     public int scheduleCourse(int[][] c) {
// //         Arrays.sort(c , Comparator.comparingInt((a) -> a[1]));
// //         int n = c.length;
// // //         int prev = 0;
// // //         int pick = 0;
// // //          HashMap<Long,Integer> hm = new HashMap<>();
// // //         hm.put(0L,0);
// // //         for(int i = 0 ; i < c.length ;i++){
// // //             if(c[i][0]>c[i][1])continue;
// // //             boolean check = true;
// // //             Set<Long> set = new HashSet<>(hm.keySet());
// // //             for(long x : set){
// // //                 if((c[i][0] + x <= c[i][1])){
// // //                     check = false;
// // //                     int num = hm.get(x);
// // //                     long key = x;
// // //                     hm.remove(x);
// // //                     hm.put(key+c[i][0],num+1);
// // //                 }
// // //             }
// // //             if (check && !hm.containsKey((long)c[i][0])) {
// // //                 hm.put((long) c[i][0], 1);
// // //             }
            
// // //         }
        
// // //         int max = 0;
        
// // //         for(int val : hm.values()){
// // //             max = Math.max(val,max);
// // //         }
// // //         return max;
        
// //         Integer[][] dp = new Integer[n+1][1000000];
// //         return solve(0,0,c,dp);
// //     }
    
// //     int solve(int idx , int prev , int[][]c,Integer[][] dp){
// //         if(idx>=c.length)return 0;
// //         if(dp[idx][prev]!= null)return dp[idx][prev];
// //         int pick = 0;
// //         if((c[idx][0] + prev <= c[idx][1])){
// //             pick = 1 + solve(idx+1,c[idx][0] + prev,c,dp);
// //         }
// //         int np = solve(idx+1,prev,c,dp);
// //         return  dp[idx][prev] = Math.max(pick,np);
// //     }
// // }

// public class Solution {
//     public int scheduleCourse(int[][] courses) {
//         Arrays.sort(courses, (a, b) -> a[1] - b[1]);
//         Integer[][] memo = new Integer[courses.length][courses[courses.length - 1][1] + 1];
//         return schedule(courses, 0, 0, memo);
//     }
//     public int schedule(int[][] courses, int i, int time, Integer[][] memo) {
//         if (i == courses.length)
//             return 0;
//         if (memo[i][time] != null)
//             return memo[i][time];
//         int taken = 0;
//         if (time + courses[i][0] <= courses[i][1])
//             taken = 1 + schedule(courses, i + 1, time + courses[i][0], memo);
//         int not_taken = schedule(courses, i + 1, time, memo);
//         memo[i][time] = Math.max(taken, not_taken);
//         return memo[i][time];
//     }
// }
public class Solution {
    public int scheduleCourse(int[][] courses) {
        System.out.println(courses.length);
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                courses[count++] = courses[i];
            } else {
                int max_i = i;
                for (int j = 0; j < count; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                    courses[max_i] = courses[i];
                }
            }
        }
        return count;
    }
}