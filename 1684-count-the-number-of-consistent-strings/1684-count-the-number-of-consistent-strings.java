class Solution {
    public int countConsistentStrings(String s, String[] words) {
        int[] map = new int[26];
        
        for(int i = 0;i<s.length();i++){
            int cal = s.charAt(i) - 'a';
            map[cal]++;
            // System.out.println(cal);
        }
        int count = 0;
        
        for(String str : words){
            boolean check = true;
            for(int i = 0;i<str.length();i++){
                int cal = str.charAt(i) - 'a';
                if(map[cal]==0){
                    check = false;
                    break;
                }
            }
            if(check)count++;
            
        }
        
        return count;
        
        
        // return 1;
        
        
    }
}