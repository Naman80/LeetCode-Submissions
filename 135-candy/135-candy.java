class Solution {
    public int candy(int[] rate) {
        int n = rate.length;
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        
        for(int i = 0 ; i < n ; i++){
        q.add(new Pair(rate[i] , i));    
        }
        
        
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        
        while(q.size()!=0){
            
            Pair p = q.remove();
            
            int idx = p.idx;
            
            if(idx - 1 >=0){
                if(rate[idx] < rate[idx-1] && dp[idx] >= dp[idx-1]){
                    dp[idx-1] = dp[idx]+1;
                }
            }
            
            if(idx+1<n){
                if(rate[idx] < rate[idx+1] && dp[idx] >= dp[idx+1]){
                    dp[idx+1] = dp[idx]+1;
                }
            }
            
        }
        
        int sum = 0;
        
        for(int i = 0;i<n;i++){
            sum+=dp[i];
        }
        
        return sum;
        
    }
}

class Pair implements Comparable<Pair>{
    int val;
    int idx;
    Pair(int val , int idx){
        this.val=val;
        this.idx = idx;
    }
    @Override
    public int compareTo(Pair other){
        return this.val - other.val;
    }
    
}