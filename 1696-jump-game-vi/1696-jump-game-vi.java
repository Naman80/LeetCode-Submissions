class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
       int n = nums.length;
        // int sum = nums[0];
//         q.add(nums[0]);
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         for(int i = 1; i < Math.min(k,n) ; i++){
//             int sum = q.peek() + nums[i];
//             dp[i] = sum;
//             q.add(sum);
//         }
        
//         for(int i = k ; i<n;i++){
            
//             int sum = q.peek()+nums[i];
//             dp[i] = sum;
//             q.remove(dp[i-k]);
//             q.add(sum);
            
//         }
        
//         return dp[n-1];
        q.add(new Pair(nums[0],0));
        int sum = nums[0];
        for(int i = 1 ; i < n ; i++){
            
            while(!q.isEmpty() && q.peek().idx+k < i){
                q.poll();
            }
           sum = q.peek().val + nums[i];
            q.add(new Pair(sum , i));
        }
        
        return sum;
        
        
    }
}

class Pair implements Comparable<Pair>{
    
    int val;int idx;
    
    Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Pair o){
        // return o.val - this.val;
        return o.val - this.val;
        
    }
    
    
}