class Solution {
    public String reverseWords(String s) {
       int n = s.length();
        
        StringBuilder ans = new StringBuilder();
        
        StringBuilder temp = new StringBuilder();
        
        
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);    
            if(ch == ' '){
                ans.append(temp.reverse());
                ans.append(ch);
                temp = new StringBuilder();
            }else{
                temp.append(ch);
            }
        }
        
        ans.append(temp.reverse());
        
        return ans.toString();
        
        
    }
}