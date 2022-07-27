class Solution {
    HashSet<String> set;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        
    set = new HashSet<>();
        
        for(String x : wordDict){
            set.add(x);
        }
        dp = new Boolean[s.length()+1];
        
        
        return solve(0,s);
        
    }
    
    
    boolean solve(int idx , String s){
        
        if(idx>=s.length())return true;
        if(dp[idx]!=null)return dp[idx];
        StringBuilder sb = new StringBuilder();
        
        for(int i = idx ; i < s.length() ; i++){
            sb.append(s.charAt(i));
            if(set.contains(String.valueOf(sb))){
                if(solve(i+1,s))return dp[i] = true;
            }
            
        }
        
        return dp[idx] = false;
        
    }
    
    
}