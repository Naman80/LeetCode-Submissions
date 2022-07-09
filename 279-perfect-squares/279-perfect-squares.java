class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> al = new ArrayList<>();
    
        perf(al);
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        int size = al.size();
        for(int i = 2 ; i < n+1;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<size ; j++){
                int in = al.get(j);
                if(in <=  i){
                    min = Math.min(min,dp[i - in]);
                }else break;
                
            }
            
            dp[i] = min+1;
        }
        
        return dp[n];
        
        
    }
    
    
    void perf(ArrayList<Integer> al){
        
        for(int i = 1 ;i <= 10000 ; i++){
            int sqr = i*i;
            if(sqr > 10000){
                break;
            }else{
                al.add(sqr);
            }
        }
        
    }
}