class Solution {
    public boolean backspaceCompare(String s, String t) {
      
      if(solve(s).equals(solve(t)))return true;
      else return false;  
    }
    
   public String solve(String s){
        
        int i = s.length()-1;
        int skip = 0;
        String ret = "";
        while(i>=0){
            while(i>=0 && s.charAt(i)=='#'){
                skip++;
                i--;
            }
            if(i>=0){
              char ch =   s.charAt(i);
                if(skip==0){
                    ret+=ch;
                    i--;
                }else{
                    i--;
                    skip--;
                }
                
            }
            
        }
        
        return ret;
        
    }
}