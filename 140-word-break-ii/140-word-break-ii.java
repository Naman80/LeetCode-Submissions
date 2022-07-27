class Solution {
    
    HashSet<String> set ;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for(String x : wordDict){
            set.add(x);
        }
        List<String> ans  = new ArrayList<>();
        
        solve(0,s,"",ans);
        return ans;
    }
    
    
    
    void solve(int idx , String s, String temp2 , List<String> ans){
        if(idx>= s.length()){
            ans.add(temp2.substring(0,temp2.length()-1));
            return ;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = idx;i<s.length();i++){
            
            sb.append(s.charAt(i));
            String st = String.valueOf(sb);
            if(set.contains(st)){
                solve(i+1 , s , temp2 + st + " ",ans );
            }
        }
        
        
    }
}