class Solution {
    String ans = "";
    public String countAndSay(int n) {
        
   
        if(n==1)return "1";
        if(n==2)return "11";
        
        solve("11", 2 , n);
        
        return ans;
        
    }
    
    
    void solve(String s,int count, int n){
        
        if(count == n){
            ans = s;
            return;
        }
        
        int len = s.length();
        
        int cn = 1;
        
        StringBuilder str = new StringBuilder();
        
        for(int i = 1 ; i<len;i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cn++;
            }else{
                str.append((char)(cn+'0'));
                str.append(s.charAt(i-1));
                cn=1;
            }
        }
        
         str.append((char)(cn+'0'));
                str.append(s.charAt(len-1));
        
        solve(String.valueOf(str),count+1,n);
        
    }
    
    
    
    
    
}