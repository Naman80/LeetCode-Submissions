class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        String ans = "";
        while(i < n){
            String temp ="";
            while(i < n && s.charAt(i)==' '){
                i++;
            }
            
            while(i < n && s.charAt(i)!=' '){
                temp+= s.charAt(i);
                i++;
            }
            
            if(temp!="")
                ans= " " + temp +ans; 
            
            
        }
        
        return ans.substring(1 , ans.length());
    }
}