class Solution {
    public boolean canChange(String s , String t) {
        int  i = 0 ;
        int j = 0 ;
        
        int sl = s.length();
        int tl = t.length();
        
        if(sl != tl)return false;
        
        
        while(i<sl && j<tl){
            
            
            while(i < sl && s.charAt(i) == '_'){
                i++;
            }
            
            while(j < tl && t.charAt(j) == '_'){
                j++;
            }
            
            if(i==sl && j == tl)return true;
            if(i == sl  || j == tl )return false;
            
            if(s.charAt(i) != t.charAt(j))return false;
            else{
                
                if(s.charAt(i) == 'L'){
                    if(j > i)return false;
                }else if(j < i)return false;
                
            }
            i++;j++;
        }
        return true;
    }
}