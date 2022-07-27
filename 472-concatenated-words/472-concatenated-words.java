class Solution {
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        for(String x : words){
            set.add(x);
        }
        List<String> ans = new ArrayList<>();
        
        for(String x : words){
            
            if(solve(x , 0))ans.add(x);
            
        }
        
        return ans;
    }
    
    
    
    boolean solve(String s, int num){
        int n = s.length();
        
        if(n==0 && num==1)return false;
        if(n==0)return true;
        StringBuilder sb = new StringBuilder();
        
        boolean check = false;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            sb.append(ch);
            String st = String.valueOf(sb);
            if(set.contains(st)){
                check = check || solve(s.substring(i+1) , num+1);
            }
        }
        
        return check;
        
        
    }
}