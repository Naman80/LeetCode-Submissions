class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.",
                         "--.","....","..",".---","-.-",".-..",
                         "--","-.","---",".--.","--.-",".-.","...",
                         "-","..-","...-",".--","-..-","-.--","--.."};
        
        
        HashSet<String> hs = new HashSet<>();
        
        for(String x : words){
            
            String form = "";
            
            for(int i = 0 ; i < x.length() ;i++){
                
                form+= codes[x.charAt(i) - 'a'];
                
            }
            hs.add(form);
        }
        
        
        return hs.size();
        
    }
}