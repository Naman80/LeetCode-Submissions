class Solution {
    boolean check = false;
    public boolean validPalindrome(String s) {
        // adbsdvdsebda
        int n = s.length();
        
        return solve( 0 , n-1 , s);
    }
    
    public boolean solve(int i , int j , String s){
        
        if(i>j)return true;
        char f = s.charAt(i);
        char e = s.charAt(j);
        
        if(f != e){
            if(check)return false;
            else{
                check = true;
                return solve(i+1 , j , s) || solve(i , j-1 , s);
                
            }
        }else return solve(i+1 , j -1 , s);
        
        
        
        
        
        
    }
    
    
}



// adbsdvdsebda
// aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga