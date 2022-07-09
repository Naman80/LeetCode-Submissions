class Solution {
    public int countVowelSubstrings(String word) {
        
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        
        int ans = 0;
        int n = word.length();
        
        for(int i = 0 ; i < n;i++){
            HashSet<Character> temp = new HashSet<>();
            for(int j = i ; j < n ; j++){
                char ch = word.charAt(j);
                if(hs.contains(ch)){
                    temp.add(ch);
                    if(temp.size() >=5)ans++;
                }else break;
                
            }
        }
                   
                   return ans;
    }
    
    
}